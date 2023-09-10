function uploadFile() {
    const fileInput = document.getElementById('fileInput');
    const alertMessage = document.getElementById('alert');
    const popup = document.getElementById('popup');
    const fileContent = document.getElementById('fileContent');

    const file = fileInput.files[0];

    const reader = new FileReader();

    reader.onload = function (e) {
        const fileData = e.target.result;
        fileContent.textContent = fileData;
        popup.style.display = 'block';
    };

    if (file.name.endsWith('.json')) {
        reader.readAsText(file);
    } else {
        alertMessage.innerHTML = 'Unsupported file format. Please select a JSON or XML file.';
        alertMessage.style.display = 'block';
    }
}
function closePopup() {
    const popup = document.getElementById('popup');
    popup.style.display = 'none';
}