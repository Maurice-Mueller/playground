function greeter(person: string) {
    return "Hello, " + person
}

var user = "Jane User"

var userGreeting = greeter(user)

interface Person {
    firstName: string
    lastName: string
}

function greetInterface(person: Person) {
    return "Hello " + person.firstName + " " + person.lastName;
}

var interfaceUser = {firstName: "jane", lastName: "user"}

var interfaceGreeting = greetInterface(interfaceUser)

class Student {
    fullName: string
    constructor(public firstName, public lastName) {
        this.fullName = firstName + ' ' + lastName
    }
}

var student = new Student("Jane", "User")

var studentInterfaceGreeting = greetInterface(student)

function greetStudent(student: Student) {
    return "Hello " + student.fullName
}

var studentGreeting = greetStudent(student)

document.body.innerHTML = 'userGreeting: ' + userGreeting + '<br>interfaceGreeting: ' + interfaceGreeting + '<br>studentInterfaceGreeting: ' + studentInterfaceGreeting + '<br>studentGreeting: ' + studentGreeting