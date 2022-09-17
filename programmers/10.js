//짝수와 홀수
function solution(num) {
    if (num < 0) {
        num = Math.abs(num);
    }
    let answer = num % 2 === 1 ? "Odd" : "Even";
    return answer;
}