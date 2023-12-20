const passwordList = [{ password: "111111" }, { password: "aaaaaa" }, { password: "bbbbbbb" }]

function createUserList() {
    return passwordList;
}


export default [
    {
        url: '/register/talent/password/validation',
        method: 'post',
        response: ({ body }) => {
            const { password } = body;
            const checkUser = createUserList().find((item) => item.password == password)
            if (!checkUser) {
                return { state: 0 }
            }
            return { state: 1 }
        }
    },

]