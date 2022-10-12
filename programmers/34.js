//H-Index
function solution(citations) {
    citations.sort((a, b) => b - a);
    let answer = 0;
    for (let i = 0; i < citations.length; i++) {
        if (citations[i] <= answer) {
            break;
        } else {
            answer++;
        }
    }
    return answer;
}