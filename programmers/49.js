//없는 숫자 더하기
function solution(numbers) {
    let answer = 45 - numbers.reduce((sum, current) => sum + current, 0);
    return answer;
}