let allJobs = [];
let currentPage = 1;
const jobsPerPage = 10;

function showAlert(type, message) {
    Swal.fire({
        icon: type,
        text: message,
        timer: 1500,
        showConfirmButton: false
    });
}

function loadJobs(keyword = "") {
    const url = keyword
        ? `http://localhost:8080/api/v1/job/search/${keyword}`
        : `http://localhost:8080/api/v1/job/getalljobs`;

    $.ajax({
        url: url,
        method: 'GET',
        success: function(response) {
            allJobs = response.data;
            currentPage = 1;
            renderJobs();
            renderPagination();
        },
        error: function(err) {
            showAlert("error", "Failed to load jobs!");
        }
    });
}

function renderJobs() {
    let rows = '';
    const start = (currentPage - 1) * jobsPerPage;
    const end = start + jobsPerPage;
    const jobsToShow = allJobs.slice(start, end);

    jobsToShow.forEach(function(job, index) {
        const toggleBtnText = job.status === 'Active' ? 'Deactivate' : 'Activate';
        const toggleBtnClass = job.status === 'Active' ? 'btn-secondary' : 'btn-success';

        rows += `<tr>
            <td>${start + index + 1}</td>
            <td>${job.jobTitle}</td>
            <td>${job.company}</td>
            <td>${job.location}</td>
            <td>${job.type}</td>
            <td>${job.status}</td>
            <td>
                <button class="btn btn-sm btn-warning edit-btn" data-id="${job.id}">Edit</button>
                <button class="btn btn-sm btn-danger delete-btn" data-id="${job.id}">Delete</button>
                <button class="btn btn-sm ${toggleBtnClass} toggle-status-btn" data-id="${job.id}" data-status="${job.status}">${toggleBtnText}</button>
            </td>
        </tr>`;
    });

    $('#jobsTableBody').html(rows);
}

function renderPagination() {
    const totalPages = Math.ceil(allJobs.length / jobsPerPage);
    let paginationHtml = '';

    if (totalPages > 1) {
        paginationHtml += `<nav><ul class="pagination justify-content-center">`;
        paginationHtml += `<li class="page-item${currentPage === 1 ? ' disabled' : ''}">
            <a class="page-link" href="#" data-page="${currentPage - 1}">Previous</a></li>`;

        for (let i = 1; i <= totalPages; i++) {
            paginationHtml += `<li class="page-item${currentPage === i ? ' active' : ''}">
                <a class="page-link" href="#" data-page="${i}">${i}</a></li>`;
        }

        paginationHtml += `<li class="page-item${currentPage === totalPages ? ' disabled' : ''}">
            <a class="page-link" href="#" data-page="${currentPage + 1}">Next</a></li>`;
        paginationHtml += `</ul></nav>`;
    }

    $('#paginationContainer').html(paginationHtml);
}

$(document).on('click', '.page-link', function(e) {
    e.preventDefault();
    const page = parseInt($(this).data('page'));
    const totalPages = Math.ceil(allJobs.length / jobsPerPage);

    if (page >= 1 && page <= totalPages) {
        currentPage = page;
        renderJobs();
        renderPagination();
    }
});

$('#saveJobBtn').click(function() {
    const jobTitle = $('#jobTitle').val().trim();
    const company = $('#companyName').val().trim();
    const location = $('#jobLocation').val().trim();
    const type = $('#jobType').val();

    if (!jobTitle || !company || !location || !type) {
        showAlert('error', 'Please fill all required fields!');
        return;
    }

    const jobData = {
        jobTitle,
        company,
        location,
        type,
        jobDescription: $('#jobDescription').val(),
        status: 'Active'
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/job/create',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(jobData),
        success: function(response) {
            showAlert('success', response.message);
            $('#addJobForm')[0].reset();
            loadJobs();
        },
        error: function() {
            showAlert('error', 'Failed to create job!');
        }
    });
});

$(document).on('click', '.edit-btn', function() {
    const id = $(this).data('id');

    $.get(`http://localhost:8080/api/v1/job/getalljobs`, function(response) {
        const job = response.data.find(j => j.id === id);
        if (job) {
            $('#editJobId').val(job.id);
            $('#editJobTitle').val(job.jobTitle);
            $('#editCompanyName').val(job.company);
            $('#editJobLocation').val(job.location);
            $('#editJobType').val(job.type);
            $('#editJobDescription').val(job.jobDescription);
            $('#editJobModal').modal('show');
        }
    });
});

$('#updateJobBtn').click(function() {
    const jobTitle = $('#editJobTitle').val().trim();
    const company = $('#editCompanyName').val().trim();
    const location = $('#editJobLocation').val().trim();
    const type = $('#editJobType').val();

    if (!jobTitle || !company || !location || !type) {
        showAlert('error', 'Please fill all required fields!');
        return;
    }

    const jobData = {
        id: $('#editJobId').val(),
        jobTitle,
        company,
        location,
        type,
        jobDescription: $('#editJobDescription').val(),
        status: 'Active'
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/job/update',
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(jobData),
        success: function(response) {
            showAlert('success', response.message);
            $('#editJobForm')[0].reset();
            loadJobs();
        },
        error: function() {
            showAlert('error', 'Failed to update job!');
        }
    });
});

$(document).on('click', '.delete-btn', function() {
    const id = $(this).data('id');
    Swal.fire({
        title: 'Are you sure?',
        text: 'You will not be able to recover this job!',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, delete it!',
        cancelButtonText: 'Cancel'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: `http://localhost:8080/api/v1/job/delete?id=${id}`,
                method: 'PUT',
                success: function(response) {
                    showAlert('success', response.message);
                    loadJobs();
                },
                error: function() {
                    showAlert('error', 'Failed to delete job!');
                }
            });
        }
    });
});

$(document).on('click', '.toggle-status-btn', function() {
    const id = $(this).data('id');
    const currentStatus = $(this).data('status');
    const action = currentStatus === 'Active' ? 'deactivate' : 'activate';

    Swal.fire({
        title: `Are you sure you want to ${action} this job?`,
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Yes',
        cancelButtonText: 'Cancel'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: `http://localhost:8080/api/v1/job/changeStatus/${id}`,
                method: 'PATCH',
                success: function(response) {
                    showAlert('success', response.message);
                    loadJobs();
                },
                error: function() {
                    showAlert('error', 'Failed to change job status!');
                }
            });
        }
    });
});

$('#searchInput').on('input', function() {
    const keyword = $(this).val();
    loadJobs(keyword);
});

$(document).ready(function() {
    loadJobs();
});
