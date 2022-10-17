//피보나치수

//1 재귀함수 / 깊이가 10000을 넘어서 런타임 에러
//계산한 숫자 캐시로 저장
let numCache = {};

function solution(n) {
    let answer = fibonacci(BigInt(n)) % BigInt(1234567);
    return BigInt(answer);
}


function fibonacci(num) {
    num = BigInt(num)
    if (num === BigInt(0)  || num === BigInt(1)) {
        return num;
    } else {
        if (!numCache[num - BigInt(2)]) {
            numCache[num - BigInt(2)] = fibonacci(num - BigInt(2));
        } 
        
        if (!numCache[num - BigInt(1)]) {
            numCache[num - BigInt(1)] = fibonacci(num - BigInt(1));
        } 
        
        return numCache[num - BigInt(2)] + numCache[num - BigInt(1)];
    }
}