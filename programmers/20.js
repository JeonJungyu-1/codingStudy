//두 큐 합 같게 만들기
function solution(queue1, queue2) {
    let sum1 = 0;
    let sum2 = 0;
    let tmp;
    queue1.map((el) => {sum1 += el});
    queue2.map((el) => {sum2 += el});
    let sum = sum1 + sum2;
    let answer = 0;
    
    while (1) {
        if (sum/2 === sum1) {
            break;
        }
        
        if (!queue1.length || !queue2.length) {
            answer = -1;
            break;
        }
        
        if (sum1 > sum2) {
            tmp = queue1.shift();
            queue2.push(tmp);
            sum1 -= tmp;
            sum2 += tmp;
            answer++;
        } else {
            tmp = queue2.shift();
            queue1.push(tmp);
            sum2 -= tmp;
            sum1 += tmp;
            answer++;
        }
    }
    
    return answer;
}