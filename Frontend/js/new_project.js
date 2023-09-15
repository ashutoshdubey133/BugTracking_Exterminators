document.addEventListener("DOMContentLoaded", function () {
    const newProjectForm = document.getElementById("newProjectForm");
    const addMemberButton = document.getElementById("addMemberButton");
    const newMemberInput = document.getElementById("newMember");
    const teamMembersSelect = document.getElementById("teamMembers");

    addMemberButton.addEventListener("click", function () {
        const newMemberName = newMemberInput.value.trim();
        if (newMemberName) {
            // Create a new option element for the team member
            const option = document.createElement("option");
            option.value = newMemberName;
            option.text = newMemberName;
            teamMembersSelect.appendChild(option);

            // Clear the input field
            newMemberInput.value = "";
        }
    });

    newProjectForm.addEventListener("submit", function (e) {
        e.preventDefault(); // Prevent form submission

        // Get form input values
        const projectName = document.getElementById("projectName").value;
        const startDate = document.getElementById("startDate").value;
        const description = document.getElementById("description").value;
        const teamMembers = Array.from(document.querySelectorAll("#teamMembers option:checked")).map(option => option.value);

        // Create a new project object
        const project = {
            projectName,
            startDate,
            description,
            teamMembers,
        };

        // Store the project data (you can use localStorage, a database, or an API)
        // For demonstration purposes, we'll use localStorage
        const projects = JSON.parse(localStorage.getItem("projects")) || [];
        projects.push(project);
        localStorage.setItem("projects", JSON.stringify(projects));

        // Redirect to the list of projects page (you can adjust this URL)
        window.location.href = "project_list.html";
    });
});
