const nameList = [{ username: "admin" }, { username: "aaaaaa" }, { username: "bbbbbbb" }]

function createUserList() {
    return nameList;
}


export default [
    {
        url: '/register/talent/name/validation',
        method: 'post',
        response: ({ body }) => {
            const { username } = body;
            const checkUser = createUserList().find((item) => item.username == username)
            if (!checkUser) {
                return { state: 0 }
            }
            return { state: 1 }
        }
    },

]
