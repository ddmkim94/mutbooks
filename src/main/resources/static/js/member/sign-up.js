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

    const password = form.password.value;
    const passwordConfirm = form.passwordConfirm.value;

    if (password !== passwordConfirm) {
        alertMessage('비밀번호가 일치하지 않습니다.');
        form.passwordConfirm.focus();
        return;
    }

    form.email.value = form.email.value.trim();
    if (form.email.value.length === 0) {
        alertMessage('이메일 입력은 필수입니다.');
        form.email.focus();
        return;
    }

    form.submit();
}