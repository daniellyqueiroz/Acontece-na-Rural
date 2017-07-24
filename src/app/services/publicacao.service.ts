import { Publicacao } from '../classes-basicas/publicacao';

export class PublicacaoService{

    
   public getBanco(): Publicacao[]{
        return [
            {
                "id": 2,
                "nome": "Danny",
                "nomeUsuario": "dani",
                "imagem": "assets/img/fotouser.jpg",
                "texto": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer et diam sit amet tortor euismod convallis. Etiam id commodo magna, nec porta sapien. Vestibulum tempus dolor velit, et ornare urna consectetur vitae. Maecenas egestas laoreet dapibus. Cras maximus sem sit amet justo tristique, nec condimentum mauris pretium. Morbi imperdiet porta ligula, a placerat urna sagittis efficitur. Morbi lacus orci, elementum quis maximus et, fringilla nec quam. Pellentesque suscipit tellus nec semper mattis. Suspendisse ultricies eget lectus et efficitur.",
                "fotos": [],
                "videos": [],
                "data": 890809,
                "pessoasCurtiram": [],
                "pessoasDescurtiram": [],
                "tags": ["ufrpe", "latim"],
                "comentarios": [
                    {
                        "id": 10,
                        "idPublicacao": 54,
                        "idUsuario": 8,
                        "nomeUsuario": "jnmarcos",
                        "nome": "Joao",
                        "imagem": "assets/img/joao.jpg",
                        "texto": "meu comentario",
                        "data": 897987,
                        "pessoasCurtiram": [],
                        "pessoasDescurtiram": []
                    },
                    {
                        "id": 11,
                        "idPublicacao": 54,
                        "idUsuario": 8,
                        "nomeUsuario": "jnmarcos",
                        "nome": "Joao",
                        "imagem": "assets/img/joao.jpg",
                        "texto": "meu comentario",
                        "data": 89908,
                        "pessoasCurtiram": [],
                        "pessoasDescurtiram": []
                    },
                    {
                        "id": 12,
                        "idPublicacao": 54,
                        "idUsuario": 8,
                        "nomeUsuario": "jnmarcos",
                        "nome": "Joao",
                        "imagem": "assets/img/joao.jpg",
                        "texto": "meu comentario",
                        "data": 7897,
                        "pessoasCurtiram": [],
                        "pessoasDescurtiram": []
                    }
                ]
            },
            {
                "id": 11,
                "nome": "Danny",
                "nomeUsuario": "dani",
                "imagem": "assets/img/fotouser.jpg",
                "texto": "Vestibulum auctor dolor vel est vestibulum, ut sodales arcu convallis. Sed faucibus dictum varius. Donec a dictum ante. Vestibulum sollicitudin dui non quam mollis, eget volutpat arcu tristique. Curabitur id accumsan lacus. Nunc vestibulum felis in felis tincidunt porta. Nam vulputate pellentesque hendrerit. Nullam laoreet lectus nunc, sed sollicitudin nisi pulvinar id. Integer pulvinar ipsum nec sapien vestibulum, at ornare quam auctor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean luctus scelerisque nisl sed fermentum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque malesuada nunc quis erat facilisis, eget aliquet augue lobortis. Fusce quis diam justo.",
                "fotos": [],
                "videos": [],
                "data": 890809,
                "pessoasCurtiram": [],
                "pessoasDescurtiram": [],
                "tags": ["ufrpe", "latim"],
                "comentarios": [
                    {
                        "id": 32,
                        "idPublicacao": 65,
                        "idUsuario": 76,
                        "nome": "Joao",
                        "nomeUsuario": "jnmarcos",
                        "imagem": "assets/img/joao.jpg",
                        "texto": "meu comentario",
                        "data": 89080,
                        "pessoasCurtiram": [],
                        "pessoasDescurtiram": []
                    }
                ]
            },
            {
                "id": 6,
                "nome": "Danny",
                "nomeUsuario": "dani",
                "imagem": "assets/img/fotouser.jpg",
                "texto": "Proin suscipit porta lacus quis suscipit. Morbi dapibus sed felis non congue. Aliquam mollis ac eros ut dictum. Nullam fermentum arcu lacus, eu sagittis purus egestas a. Suspendisse ut cursus velit, ut pretium lacus. Etiam dapibus dolor urna. Nunc blandit urna maximus, convallis libero in, sagittis est. Nam sem ipsum, pretium non lacus et, gravida placerat est. Proin vestibulum ex odio, et eleifend libero rutrum nec. Donec id sapien lacus.",
                "fotos": [],
                "videos": [],
                "data": 890809,
                "pessoasCurtiram": [],
                "pessoasDescurtiram": [],
                "tags": ["ufrpe"],
                "comentarios": [
                    {
                        "id": 11,
                        "idPublicacao": 54,
                        "idUsuario": 8,
                        "nomeUsuario": "jnmarcos",
                        "nome": "Joao",
                        "imagem": "assets/img/joao.jpg",
                        "texto": "Donec vel lobortis eros, vitae elementum metus. Nullam at libero eu sapien feugiat posuere. Ut tincidunt ligula leo, ac ornare nulla varius facilisis. Mauris sed accumsan neque, sit amet sollicitudin dolor. Suspendisse imperdiet porttitor vehicula. Fusce tristique erat a lobortis varius. In egestas purus et pretium laoreet. Phasellus vehicula vitae ante in vulputate. Praesent et turpis mattis dolor imperdiet sagittis molestie quis lorem.",
                        "data": 890809,
                        "pessoasCurtiram": [],
                        "pessoasDescurtiram": []
                    }
                ]
            }
        ]
    }
}