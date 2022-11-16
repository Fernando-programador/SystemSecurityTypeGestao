# security-gestao
projeto de segurança com nova forma de usar o serviço WebSecurityCopnfig


os metodos de segurança

Primeira classe a ser criada vaiser a JWTService
ela é a classe que vai criar o token

cria a chave dentro dela e o tempo de expiração apenas por ser um teste, mas o idela é criar fora

o que ela faz?
1 gera uym token
2 ela me traz o id do usuario do token
 
 
 
 para continuar sera preciso criar o SERVICE
 
 
 apos o service vamos criAR O CustomUserDetailsService
 
 a proxima a ser criar é a classe JwtAuthenticayionFilter
 essa classe é a primiera a ser requisitada pelo sistema
 é atrves dela se vamos saber se o usuario tem ou nao autorização para ter acesso
 
 

