//입국심사
function solution(n, times) {
    let answer = 0;
    let low = 0;
    let high = Math.max(...times) * n;
    while (low < high) {
        let mid = Math.floor((low + high) / 2);
        let people = 0;
        for (let i = 0; i < times.length; i++) {
            people += Math.floor(mid / times[i]);
        }
        
        if (people >= n) {
            high = mid;    
        } else {
            low = mid + 1;
        }
        answer = high;
    }
    return answer;
}