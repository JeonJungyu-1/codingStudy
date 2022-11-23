//두 정수 사이의 합
function solution(a, b) {
    let answer = 0;
    if (a === b) {
        return a;
    }
    if (a > b) {
        [a, b] = [b, a];
    }
    
    for (let i = a; i < b + 1; i++) {
        answer += i;
    }
    return answer;
}
 
