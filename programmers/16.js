//가장 큰 수
function solution(numbers) {
    let answer = "";
    numbers.sort(sortFunction);
    answer = numbers.join("");
    return answer[0] === "0" ? "0" : answer;
}

function sortFunction(a, b) {
    return Number(String(b) + String(a)) - Number(String(a) + String(b));
}