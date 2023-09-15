document.addEventListener("DOMContentLoaded", function() {
    const viewProjectsBtn = document.getElementById("view-projects-btn");
    const projectsSection = document.getElementById("projects");
    const bugSection = document.getElementById("bugs");
    const projectList = document.getElementById("project-list");
    const bugList = document.getElementById("bug-list");

    // Simulated project and bug data (replace with your data source)
    const projectsData = ["Project A", "Project B", "Project C"];
    const bugsData = {
        "Project A": ["Bug 1", "Bug 2", "Bug 3"],
        "Project B": ["Bug 4", "Bug 5"],
        "Project C": ["Bug 6"]
    };

    // Function to populate the project list
    function populateProjectList() {
        projectList.innerHTML = "";
        projectsData.forEach(project => {
            const listItem = document.createElement("li");
            listItem.textContent = project;
            listItem.addEventListener("click", () => {
                // Populate the bug list for the selected project
                populateBugList(project);
            });
            projectList.appendChild(listItem);
        });
    }

    // Function to populate the bug list for a specific project
    function populateBugList(project) {
        bugList.innerHTML = "";
        bugsData[project].forEach(bug => {
            const listItem = document.createElement("li");
            listItem.textContent = bug;
            bugList.appendChild(listItem);
        });
    }

    // Add an event listener to the "View Projects" button
    viewProjectsBtn.addEventListener("click", function() {
        // Populate the project list
        populateProjectList();

        // Show the sections
        projectsSection.style.display = "block";
        bugSection.style.display = "block";
    });
});
