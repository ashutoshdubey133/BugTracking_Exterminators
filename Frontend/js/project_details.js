document.addEventListener("DOMContentLoaded", function () {
    const projectDetails = document.getElementById("projectDetails");

    // Retrieve the project index from the query parameter
    const params = new URLSearchParams(window.location.search);
    const index = params.get("index");

    // Retrieve project data from localStorage or another data source
    const projects = JSON.parse(localStorage.getItem("projects")) || [];

    // Check if the index is valid and within the projects array length
    if (index !== null && index >= 0 && index < projects.length) {
        const project = projects[index];

        // Display project details on the page
        projectDetails.innerHTML = `
            <p>Project Name: ${project.projectName}</p>
            <p>Start Date: ${project.startDate}</p>
            <p>Description: ${project.description}</p>
        `;

        // You can similarly display other project details, such as team members and bugs.
    } else {
        projectDetails.innerHTML = "<p>Project not found</p>";
    }
});
