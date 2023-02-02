//택배 배달과 수거하기
function solution(cap, n, deliveries, pickups) {
    let answer = 0;
    let maxDeliveries = -1;
    let maxPickups = -1;
    let count = 0;
    const searchDeliveries = () => {
        for (let i = n - 1; i >= 0; i++) {
            if (maxDeliveries === -1 && deliveries[i] !== 0) {
                maxDeliveries = i;
                count += deliveries[i];
                if (count > n) {
                    deliveries[i] = count - n;
                    i--;
                    answer += maxDeliveries;
                    maxDeliveries = -1;
                    searchPickups();
                    count = 0;
                } else {
                    deliveries[i] = 0;
                }
            }
        }
    };

    const searchPickups = () => {
        for (let i = n - 1; i >= 0; i++) {
            if (maxPickups === -1 && pickups[i] !== 0) {
                maxPickups = i;
                count -= pickups[i];
                if (count < 0) {
                    pickups[i] = Math.abs(count);
                    answer += maxPickups;
                    maxPickups = -1;
                    return;
                } else {
                    pickups[i] = 0;
                }
            }
        }
    };
    

    return answer;
}