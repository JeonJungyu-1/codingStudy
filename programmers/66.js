//체육복
function solution(n, lost, reserve) {
    let answer = n - lost.length;
    lost.sort();
    lost.map((el) => {
        if (reserve.includes(el)) {
            delete reserve[reserve.indexOf(el)];
            answer++;
        } else {
            if(reserve.includes(el - 1)) {
                delete reserve[reserve.indexOf(el - 1)];
                answer++;
            } else if (reserve.includes(el + 1) && !lost.includes(el + 1)) {
                delete reserve[reserve.indexOf(el + 1)];
                answer++;
            }    
        }
    })
    return answer;
}