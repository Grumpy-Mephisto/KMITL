const salaryList = [50000, 60000, 55000, 70000]

const itr = salaryList[Symbol.iterator]()

let result = itr.next()
while (!result.done) {
  console.log(result.value)
  result = itr.next()
}
