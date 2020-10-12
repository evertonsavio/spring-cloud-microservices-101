const jwt = require('jsonwebtoken');

module.exports = async function(req, res, next){
    const token = req.header('authorization');
    if(!token) return res.status(401).send("Acesso negado");

    //console.log(token)
    console.log(token)
    tokenToDecode = token.split(' ');

    //console.log(tokenToDecode[1]);

    try {
    console.log(jwt.verify(tokenToDecode[1], Buffer.from('#*gh23848gjse03', 'base64'), {algorithms:['HS512']}));
    
    } catch (error) {
        console.log(error)
    }
    

    //console.log(token + decoded);

    next();
}