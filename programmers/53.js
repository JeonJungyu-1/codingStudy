//수박수박수박
function solution(n) {
    let answer = "";
    let m = Math.floor(n/2);
    for (let i = 0; i < m; i++) {
        answer += "수박";
    }
    
    if (n % 2 === 1) {
        answer += "수";
    }
    return answer;
}