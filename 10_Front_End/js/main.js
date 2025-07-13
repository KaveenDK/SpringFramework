let allJobs = [];
let currentPage = 1;
const jobsPerPage = 10;

// Load all jobs and display in table with pagination
function loadJobs(keyword = "") {
    let url = keyword
        ? `http://localhost:8080/api/v1/job/search/${keyword}`
        : `http://localhost:8080/api/v1/job/getalljobs`;
    $.ajax({
        url: url,
        method: 'GET',
        success: function(data) {
            allJobs = data;
            currentPage = 1;
            renderJobs();
            renderPagination();
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

// Pagination click handler
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

// Add a new job
$('#saveJobBtn').click(function() {
    const jobData = {
        jobTitle: $('#jobTitle').val(),
        company: $('#companyName').val(),
        location: $('#jobLocation').val(),
        type: $('#jobType').val(),
        jobDescription: $('#jobDescription').val(),
        status: 'Active'
    };
    $.ajax({
        url: 'http://localhost:8080/api/v1/job/create',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(jobData),
        success: function(response) {
            alert(response);
            $('#addJobForm')[0].reset();
            loadJobs();
        }
    });
});

// Show edit modal with job data
$(document).on('click', '.edit-btn', function() {
    const id = $(this).data('id');
    $.get(`http://localhost:8080/api/v1/job/getalljobs`, function(data) {
        const job = data.find(j => j.id === id);
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

// Update job
$('#updateJobBtn').click(function() {
    const jobData = {
        id: $('#editJobId').val(),
        jobTitle: $('#editJobTitle').val(),
        company: $('#editCompanyName').val(),
        location: $('#editJobLocation').val(),
        type: $('#editJobType').val(),
        jobDescription: $('#editJobDescription').val(),
        status: 'Active'
    };
    $.ajax({
        url: 'http://localhost:8080/api/v1/job/update',
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(jobData),
        success: function(response) {
            alert(response);
            $('#editJobForm')[0].reset();
            loadJobs();
        }
    });
});

// Delete job
$(document).on('click', '.delete-btn', function() {
    const id = $(this).data('id');
    if (confirm('Are you sure you want to delete this job?')) {
        $.ajax({
            url: `http://localhost:8080/api/v1/job/delete?id=${id}`,
            method: 'PUT',
            success: function(response) {
                alert(response);
                loadJobs();
            }
        });
    }
});

// Toggle job status (Activate/Deactivate)
$(document).on('click', '.toggle-status-btn', function() {
    const id = $(this).data('id');
    const currentStatus = $(this).data('status');
    const action = currentStatus === 'Active' ? 'deactivate' : 'activate';
    if (confirm(`Are you sure you want to ${action} this job?`)) {
        $.ajax({
            url: `http://localhost:8080/api/v1/job/changeStatus/${id}`,
            method: 'PATCH',
            success: function(response) {
                alert(response);
                loadJobs();
            }
        });
    }
});

// Search jobs
$('#searchInput').on('input', function() {
    const keyword = $(this).val();
    loadJobs(keyword);
});

// Initial load
$(document).ready(function() {
    loadJobs();
});