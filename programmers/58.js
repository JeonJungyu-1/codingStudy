//네트워크
function solution(n, computers) {
    let answer = 0;
    let isVisit = {};
    
    for (let i = 0; i < n; i++) {
        isVisit[i] = false;
    }
    
    function exploreNetwork(start) {
        const visitArr = [start];
        while (visitArr.length > 0) {
            let currentVisit = visitArr.pop();
            isVisit[currentVisit] = true;
            for (let i = 0; i < n; i++) {
                if (!isVisit[i] && computers[currentVisit][i]) {
                    visitArr.push(i);
                }
            }
        }
    }
    
    
    for (let i = 0; i < n; i++) {
        if (!isVisit[i]) {
            exploreNetwork(i);
            answer++;
        }
    }
    return answer;
}
