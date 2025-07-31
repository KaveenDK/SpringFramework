$(document).ready(function () {

    // === SIGNUP FUNCTION ===
    $("#signup-form").on("submit", function (e) {
        e.preventDefault();

        const username = $("#username").val().trim();
        const password = $("#password").val().trim();
        const confirmPassword = $("#confirm-password").val().trim();
        const role = $("#role").val();

        // === VALIDATION ===
        if (!username || !password || !confirmPassword || !role) {
            Swal.fire("Missing Fields", "All fields are required!", "warning");
            return;
        }

        if (password.length < 6) {
            Swal.fire("Weak Password", "Password must be at least 6 characters.", "warning");
            return;
        }

        if (password !== confirmPassword) {
            Swal.fire("Mismatch", "Passwords do not match.", "error");
            return;
        }

        // === API REQUEST ===
        $.ajax({
            url: "http://localhost:8080/auth/signup",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                username: username,
                password: password,
                role: role
            }),
            success: function (response) {
                Swal.fire("Success", response.data || "User registered!", "success").then(() => {
                    resetSignupFields();
                    window.location.href = "signin.html";
                });
            },
            error: function (xhr) {
                const errorMsg = xhr.responseJSON?.data || "Registration failed!";
                Swal.fire("Error", errorMsg, "error");
            }
        });

        function resetSignupFields() {
            $("#username").val("");
            $("#password").val("");
            $("#confirm-password").val("");
            $("#role").val("USER");
        }
    });

    // === SIGNIN FUNCTION ===
    $("#signin-form").on("submit", function (e) {
        e.preventDefault();

        const username = $("#username").val().trim();
        const password = $("#password").val().trim();

        if (!username || !password) {
            Swal.fire("Missing Fields", "Please enter both username and password.", "warning");
            return;
        }

        // === API REQUEST ===
        $.ajax({
            url: "http://localhost:8080/auth/signin",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                username: username,
                password: password
            }),
            success: function (response) {
                const token = response.data.accessToken;

                localStorage.setItem("token", token);
                localStorage.setItem("username", username);

                Swal.fire("Success", "Login successful!", "success").then(() => {
                    $.ajax({
                        url: "http://localhost:8080/hello/user",
                        method: "GET",
                        headers: {
                            "Authorization": "Bearer " + token
                        },
                        success: function () {
                            window.location.href = "userDashboard.html";
                        },
                        error: function () {
                            // If not USER, try ADMIN
                            $.ajax({
                                url: "http://localhost:8080/hello/admin",
                                method: "GET",
                                headers: {
                                    "Authorization": "Bearer " + token
                                },
                                success: function () {
                                    window.location.href = "adminDashboard.html";
                                },
                                error: function () {
                                    Swal.fire("Access Denied", "You do not have access to this dashboard.", "error");
                                }
                            });
                        }
                    });
                });
            },
            error: function (xhr) {
                const errorMsg = xhr.responseJSON?.data || "Login failed!";
                Swal.fire("Error", errorMsg, "error");
            }
        });
    });

});

// === LOGOUT FUNCTIONALITY ===
$(document).on("click", "#logoutBtn", function () {
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    window.location.href = "../index.html";
});