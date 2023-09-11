let bugData = [
    {
        "id": 1,
        "description": "UI layout issue",
        "status": "Open"
    },
    {
        "id": 2,
        "description": "API endpoint error",
        "status": "Closed"
    },
    {
        "id": 3,
        "description": "Authentication problem",
        "status": "Open"
    }
];

function renderBugData() {
    const bugListElement = document.getElementById('bugList');
    bugListElement.innerHTML = '';

    bugData.forEach(bug => {
        const bugCard = document.createElement('div');
        bugCard.className = 'card mb-3';
        bugCard.innerHTML = `
            <div class="card-body">
                <h5 class="card-title">Bug ID: ${bug.id}</h5>
                <p class="card-text">Description: ${bug.description}</p>
                <p class="card-text">Status: ${bug.status}</p>
                <button class="btn btn-primary" data-id="${bug.id}">Toggle Status</button>
            </div>
        `;
        bugListElement.appendChild(bugCard);
    });
    const toggleStatusButtons = document.querySelectorAll('.btn-primary');
    toggleStatusButtons.forEach(button => {
        button.addEventListener('click', toggleBugStatus);
    });
}

function toggleBugStatus(event) {
    const bugId = parseInt(event.target.getAttribute('data-id'));
    bugData = bugData.map(bug => {
        if (bug.id === bugId) {
            bug.status = bug.status === 'Open' ? 'Closed' : 'Open';
        }
        return bug;
    });
    renderBugData();
}
renderBugData();