//다리를 지나는 트럭 (코드 정리하기)
function solution(bridge_length, weight, truck_weights) {
    let answer = 1;
    let bridge = new Array(bridge_length).fill(0);
    let cnt = 0;
    let truckLength = truck_weights.length;
    let truckWeight = 0;
    while (1) {
        if (!truck_weights.length && cnt === truckLength) {
            break;
        }
        truckWeight = addWeight(bridge);
        if ((truckLength - cnt - truck_weights.length) < bridge_length && truck_weights.length &&(truckWeight + truck_weights[0]) <= weight) {
            if (bridge.length !== bridge_length) {
                bridge.push(truck_weights.shift());
                answer++;
                continue;
            }
            if (bridge.shift() !== 0) {
                cnt++;
            }
            bridge.push(truck_weights.shift());
            if (addWeight(bridge) === 0) continue;
            answer++;
        } else {

            if (bridge.shift() !== 0) {
                cnt++
            }
            bridge.push(0);
            let temp = addWeight(bridge);
            if ( temp === 0) continue;
            if ((truckLength - cnt - truck_weights.length) < bridge_length && truck_weights.length &&(temp + truck_weights[0]) <= weight)  {
                bridge.pop();
                continue;
            }
            answer++;
        }
    }
    return answer;
}

function addWeight(truck) {
    return truck.reduce((sum, current) => sum + current, 0);
}