//다리를 지나는 트럭 (푸는 중)
function solution(bridge_length, weight, truck_weights) {
    let answer = 0;
    let bridge = new Array(bridge_length).fill(0);
    let truckWeight = 0;
    while (truck_weights.length || bridge.length) {
        if (!truck_weights.length && bridge.length) {
            answer += bridge.length;
            break;
        }
        truckWeight = addWeight(bridge);
        
        if (bridge.length < bridge_length && (truckWeight + truck_weights[0]) <= weight) {
            bridge.push(truck_weights.shift());
            answer++;
        } else {
            bridge.shift();
            answer++;
        }
    }
    return answer;
}

function addWeight(truck) {
    return truck.reduce((sum, current) => sum + current, 0);
}