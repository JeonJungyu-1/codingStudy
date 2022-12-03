//나누어 떨어지는 숫자 배열
function solution(arr, divisor) {
    let answer = arr.filter((el) => el % divisor === 0).sort((a, b) => a - b);
    if (!answer.length) {
        answer.push(-1);
    }
    return answer;
}