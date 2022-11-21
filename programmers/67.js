//문자열 다루기 기본
function solution(s) {
    let answer = false;
    if (!isNaN(s) && !s.includes("e")) {
        if (s.length === 4 || s.length === 6) {
            answer = true;
        }
    }
    return answer;
}