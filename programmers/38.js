//최솟값 만들기
function solution(A,B){
    A.sort((a, b) => a - b);
    B.sort((a, b) => b - a);
    
    let answer = A.reduce((sum, current, index) => sum + (current * B[index]), 0);

    return answer;
}