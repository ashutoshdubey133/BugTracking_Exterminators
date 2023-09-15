const form = document.querySelector('form');
form.addEventListener('submit', (event) = {
  event.preventDefault();
  const username = form.querySelector('input[name=username]').value;
  const password = form.querySelector('input[name=password]').value;
   Validate the username and password
  if (username === ''  password === '') {
    alert('Please enter a username and password.');
    return;
  }
   Send the username and password to the server
  const xhr = new XMLHttpRequest();
  xhr.open('POST', 'login');
  xhr.setRequestHeader('Content-Type', 'applicationjson');
  xhr.send(JSON.stringify({ username, password }));
  xhr.onload = () = {
    if (xhr.status === 200) { 
       The login was successful
      window.location.href = '../html/index1.html';
    } else {
       The login failed
      alert('Invalid username or password.');
    }
  };
});