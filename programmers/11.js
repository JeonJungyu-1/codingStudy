//자릿수 더하기
function solution(n) {
    let answer = 0;

    for (let value of String(n)) {
        answer += Number(value);
    }

    return answer;
}