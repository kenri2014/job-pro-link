export default [
    {
        url: '/register/talent',
        method: 'post',
        response: (body) => {
            return { "talentId": '@Integer' }
        }
    },
    //头像
    {
        url: '/register/talent/avatar',
        method: 'post',
        response: () => {
            return { "avatar": '@Integer' }
        }
    }
]


