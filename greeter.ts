function greeter(person: string) {
    return "Hello, " + person
}

var user = "Jane User"

document.body.innerHTML = greeter(user)

interface Person {
    firstName: string
    lastName: string
}

function greetInterface(person: Person) {
    return "Hello " + person.firstName + " " + person.lastName;
}

var interfaceUser = {firstName: "jane", lastName: "user"}

document.body.innerHTML = greetInterface(interfaceUser)