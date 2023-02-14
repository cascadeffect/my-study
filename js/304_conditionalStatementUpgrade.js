function isKoreanFood(food) {
  if (['불고기', '떡볶이', '비빔밥'].includes(food)) {
    return true;
  }
  return false;
}
const food1 = isKoreanFood('불고기');
const food2 = isKoreanFood('파스타');
console.log(food1);
console.log(food2);

const meal = {
  한식: '불고기',
  양식: '파스타',
  일식: '스시',
  중식: '딤섬',
};
const getMeal = (mealType) => {
  return meal[mealType] || '굶기';
};
console.log(getMeal('한식'));
console.log(getMeal('중식'));
console.log(getMeal('베트남식'));
