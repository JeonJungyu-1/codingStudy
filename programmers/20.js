//두 큐 합 같게 만들기
//1 shift 사용해서 시간 초과
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

//2 90점 테스트케이스 2개 에러
function solution(queue1, queue2) {
    let sum1 = 0;
    let sum2 = 0;
    let tmp;
    let tmp1 = 0;
    let tmp2 = 0;
    queue1.map((el) => {sum1 += el});
    queue2.map((el) => {sum2 += el});
    let sum = sum1 + sum2;
    let answer = 0;
    let len = [...queue1].length;
    while (1) {
        if (sum % 2 !== 0) {
            answer = -1;
            break;
        }
        if (sum/2 === sum1) {
            break;
        }
        
        // if (!queue1.length || !queue2.length) {
        //     answer = -1;
        //     break;
        // }
        // console.log(queue2, len);
        
        
        
        if (sum2 === sum || sum1 === sum) {
            answer = -1;
            break;
        }
        
        if (sum1 > sum/2) {
            // tmp = queue1.shift();
            queue2.push(queue1[tmp1]);
            sum1 -= queue1[tmp1];
            // sum2 += queue1[tmp1];
            tmp1++;
            answer++;
        } else if (sum1 < sum/2) {
            // tmp = queue2.shift();
            queue1.push(queue2[tmp2]);
            // sum2 -= queue2[tmp2];
            sum1 += queue2[tmp2];
            tmp2++;
            answer++;
        }
    }
    
    return answer;
}

//3 성공
function solution(queue1, queue2) {
    let sum1 = 0;
    let sum2 = 0;
    let tmp1 = 0;
    let tmp2 = queue1.length;
    queue1.map((el) => {sum1 += el});
    queue2.map((el) => {sum2 += el});
    let sum = sum1 + sum2;
    let count = 0;
    
    let queue = [...queue1, ...queue2, ...queue1, ...queue2];
    let len = queue.length;
    while (count <= len) {
        if (sum / 2 > sum1) {
            sum1 += queue[tmp2];
            tmp2++;
            count++;
        } else if (sum / 2 < sum1) {
            sum1 -= queue[tmp1];
            tmp1++;
            count++;
        } else {
            return count;
        }
    }
    
    return -1;
}