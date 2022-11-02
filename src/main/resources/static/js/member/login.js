'use strict';

const sweetAlert = document.querySelector('.alert');

function alertMessage(message) {
    sweetAlert.innerHTML = message;
    sweetAlert.style.display = 'block';
}

function check(form) {
    form.username.value = form.username.value.trim();
    if (form.username.value.length === 0) {
        alertMessage('아이디를 입력은 필수입니다.');
        form.username.focus();
        return;
    }

    form.password.value = form.password.value.trim();
    if (form.password.value.length === 0) {
        alertMessage('비밀번호 입력은 필수입니다.');
        form.password.focus();
        return;
    }

    form.submit();
}