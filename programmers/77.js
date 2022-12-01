//두 개 뽑아서 더하기
function solution(numbers) {
    let answer = [];
    for (let i = 0; i < numbers.length - 1; i++) {
        for (let j = i + 1; j < numbers.length; j++) {
            answer.push(numbers[i] + numbers[j]);
        }
    }
    answer = Array.from(new Set([...answer])).sort((a, b) => a - b);
    return answer;
}