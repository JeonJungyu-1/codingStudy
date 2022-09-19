//폰켓몬
function solution(nums) {
    let set = new Set(nums);
    return Math.min(set.size, nums.length / 2);
}