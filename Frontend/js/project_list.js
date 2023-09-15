document.addEventListener("DOMContentLoaded", function () {
    const projectList = document.getElementById("projectList");

    // Retrieve project data from localStorage (you can adjust this if you use a database or API)
    const projects = JSON.parse(localStorage.getItem("projects")) || [];

    // Function to delete a project by index
    function deleteProject(index) {
        // Remove the project from the projects array
        projects.splice(index, 1);

        // Save the updated projects array back to localStorage
        localStorage.setItem("projects", JSON.stringify(projects));

        // Refresh the project list to reflect the changes
        displayProjects();
    }

    // Function to display project details in the list
    function displayProjects() {
        projectList.innerHTML = ""; // Clear the list

        projects.forEach((project, index) => {
            const listItem = document.createElement("li");
            listItem.innerHTML = `
                <span>${project.projectName}</span>
                <a href="project_details.html?index=${index}">Details</a>
                <button class="delete-button" data-index="${index}">Delete</button>
            `;
            projectList.appendChild(listItem);
        });

        // Add event listeners to delete buttons
        const deleteButtons = document.querySelectorAll(".delete-button");
        deleteButtons.forEach((button) => {
            button.addEventListener("click", function () {
                const indexToDelete = parseInt(button.getAttribute("data-index"));
                if (!isNaN(indexToDelete)) {
                    if (confirm("Are you sure you want to delete this project?")) {
                        deleteProject(indexToDelete);
                    }
                }
            });
        });
    }

    // Initial display of projects
    displayProjects();
});
