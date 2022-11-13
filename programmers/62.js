//핸드폰 번호 가리기
function solution(phone_number) {
    let answer = '';
    let phoneNumberLength = phone_number.length;
    answer = [...phone_number].map((el, index) => phoneNumberLength - 5 < index ? el : "*").join("");
    return answer;
}