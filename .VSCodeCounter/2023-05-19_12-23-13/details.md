# Details

Date : 2023-05-19 12:23:13

Directory c:\\Users\\fani6\\rollinter\\RollinterServer

Total : 57 files,  3552 codes, 280 comments, 1097 blanks, all 4929 lines

[Summary](results.md) / Details / [Diff Summary](diff.md) / [Diff Details](diff-details.md)

## Files
| filename | language | code | comment | blank | total |
| :--- | :--- | ---: | ---: | ---: | ---: |
| [.github/workflows/master_rollinter.yml](/.github/workflows/master_rollinter.yml) | YAML | 41 | 2 | 11 | 54 |
| [.mvn/wrapper/maven-wrapper.properties](/.mvn/wrapper/maven-wrapper.properties) | Java Properties | 2 | 0 | 1 | 3 |
| [docs/rollinter.sql](/docs/rollinter.sql) | SQL | 468 | 118 | 63 | 649 |
| [mvnw.cmd](/mvnw.cmd) | Batch | 102 | 51 | 36 | 189 |
| [pom.xml](/pom.xml) | XML | 84 | 2 | 5 | 91 |
| [src/main/java/net/ausiasmarch/rollinter/RollinterApplication.java](/src/main/java/net/ausiasmarch/rollinter/RollinterApplication.java) | Java | 9 | 0 | 5 | 14 |
| [src/main/java/net/ausiasmarch/rollinter/api/Chat_TeamController.java](/src/main/java/net/ausiasmarch/rollinter/api/Chat_TeamController.java) | Java | 53 | 9 | 15 | 77 |
| [src/main/java/net/ausiasmarch/rollinter/api/CommentController.java](/src/main/java/net/ausiasmarch/rollinter/api/CommentController.java) | Java | 51 | 9 | 17 | 77 |
| [src/main/java/net/ausiasmarch/rollinter/api/CoordinatesController.java](/src/main/java/net/ausiasmarch/rollinter/api/CoordinatesController.java) | Java | 50 | 0 | 16 | 66 |
| [src/main/java/net/ausiasmarch/rollinter/api/ReactionController.java](/src/main/java/net/ausiasmarch/rollinter/api/ReactionController.java) | Java | 50 | 4 | 16 | 70 |
| [src/main/java/net/ausiasmarch/rollinter/api/RouteController.java](/src/main/java/net/ausiasmarch/rollinter/api/RouteController.java) | Java | 61 | 0 | 17 | 78 |
| [src/main/java/net/ausiasmarch/rollinter/api/SessionController.java](/src/main/java/net/ausiasmarch/rollinter/api/SessionController.java) | Java | 25 | 9 | 13 | 47 |
| [src/main/java/net/ausiasmarch/rollinter/api/TeamController.java](/src/main/java/net/ausiasmarch/rollinter/api/TeamController.java) | Java | 65 | 0 | 19 | 84 |
| [src/main/java/net/ausiasmarch/rollinter/api/UserController.java](/src/main/java/net/ausiasmarch/rollinter/api/UserController.java) | Java | 65 | 0 | 15 | 80 |
| [src/main/java/net/ausiasmarch/rollinter/api/UsertypeController.java](/src/main/java/net/ausiasmarch/rollinter/api/UsertypeController.java) | Java | 41 | 0 | 14 | 55 |
| [src/main/java/net/ausiasmarch/rollinter/bean/ErrorResponseBean.java](/src/main/java/net/ausiasmarch/rollinter/bean/ErrorResponseBean.java) | Java | 38 | 0 | 14 | 52 |
| [src/main/java/net/ausiasmarch/rollinter/bean/UserBean.java](/src/main/java/net/ausiasmarch/rollinter/bean/UserBean.java) | Java | 22 | 0 | 11 | 33 |
| [src/main/java/net/ausiasmarch/rollinter/entity/Chat_TeamEntity.java](/src/main/java/net/ausiasmarch/rollinter/entity/Chat_TeamEntity.java) | Java | 61 | 0 | 26 | 87 |
| [src/main/java/net/ausiasmarch/rollinter/entity/CommentEntity.java](/src/main/java/net/ausiasmarch/rollinter/entity/CommentEntity.java) | Java | 61 | 0 | 24 | 85 |
| [src/main/java/net/ausiasmarch/rollinter/entity/CoordinatesEntity.java](/src/main/java/net/ausiasmarch/rollinter/entity/CoordinatesEntity.java) | Java | 56 | 0 | 18 | 74 |
| [src/main/java/net/ausiasmarch/rollinter/entity/ReactionEntity.java](/src/main/java/net/ausiasmarch/rollinter/entity/ReactionEntity.java) | Java | 52 | 0 | 18 | 70 |
| [src/main/java/net/ausiasmarch/rollinter/entity/RouteEntity.java](/src/main/java/net/ausiasmarch/rollinter/entity/RouteEntity.java) | Java | 95 | 0 | 33 | 128 |
| [src/main/java/net/ausiasmarch/rollinter/entity/TeamEntity.java](/src/main/java/net/ausiasmarch/rollinter/entity/TeamEntity.java) | Java | 81 | 0 | 35 | 116 |
| [src/main/java/net/ausiasmarch/rollinter/entity/UserEntity.java](/src/main/java/net/ausiasmarch/rollinter/entity/UserEntity.java) | Java | 150 | 0 | 57 | 207 |
| [src/main/java/net/ausiasmarch/rollinter/entity/UsertypeEntity.java](/src/main/java/net/ausiasmarch/rollinter/entity/UsertypeEntity.java) | Java | 50 | 0 | 14 | 64 |
| [src/main/java/net/ausiasmarch/rollinter/exception/AppExceptionHandler.java](/src/main/java/net/ausiasmarch/rollinter/exception/AppExceptionHandler.java) | Java | 41 | 0 | 10 | 51 |
| [src/main/java/net/ausiasmarch/rollinter/exception/CannotPerformOperationException.java](/src/main/java/net/ausiasmarch/rollinter/exception/CannotPerformOperationException.java) | Java | 6 | 0 | 5 | 11 |
| [src/main/java/net/ausiasmarch/rollinter/exception/JWTException.java](/src/main/java/net/ausiasmarch/rollinter/exception/JWTException.java) | Java | 6 | 0 | 4 | 10 |
| [src/main/java/net/ausiasmarch/rollinter/exception/ResourceNotFoundException.java](/src/main/java/net/ausiasmarch/rollinter/exception/ResourceNotFoundException.java) | Java | 6 | 0 | 5 | 11 |
| [src/main/java/net/ausiasmarch/rollinter/exception/ResourceNotModifiedException.java](/src/main/java/net/ausiasmarch/rollinter/exception/ResourceNotModifiedException.java) | Java | 6 | 0 | 5 | 11 |
| [src/main/java/net/ausiasmarch/rollinter/exception/UnauthorizedException.java](/src/main/java/net/ausiasmarch/rollinter/exception/UnauthorizedException.java) | Java | 6 | 0 | 5 | 11 |
| [src/main/java/net/ausiasmarch/rollinter/exception/ValidationException.java](/src/main/java/net/ausiasmarch/rollinter/exception/ValidationException.java) | Java | 6 | 0 | 5 | 11 |
| [src/main/java/net/ausiasmarch/rollinter/filter/CORSFilter.java](/src/main/java/net/ausiasmarch/rollinter/filter/CORSFilter.java) | Java | 31 | 0 | 17 | 48 |
| [src/main/java/net/ausiasmarch/rollinter/filter/JWTFilter.java](/src/main/java/net/ausiasmarch/rollinter/filter/JWTFilter.java) | Java | 43 | 0 | 10 | 53 |
| [src/main/java/net/ausiasmarch/rollinter/helper/JwtHelper.java](/src/main/java/net/ausiasmarch/rollinter/helper/JwtHelper.java) | Java | 44 | 0 | 13 | 57 |
| [src/main/java/net/ausiasmarch/rollinter/helper/RandomHelper.java](/src/main/java/net/ausiasmarch/rollinter/helper/RandomHelper.java) | Java | 64 | 0 | 18 | 82 |
| [src/main/java/net/ausiasmarch/rollinter/helper/UsertypeHelper.java](/src/main/java/net/ausiasmarch/rollinter/helper/UsertypeHelper.java) | Java | 5 | 0 | 5 | 10 |
| [src/main/java/net/ausiasmarch/rollinter/helper/ValidationHelper.java](/src/main/java/net/ausiasmarch/rollinter/helper/ValidationHelper.java) | Java | 91 | 0 | 25 | 116 |
| [src/main/java/net/ausiasmarch/rollinter/repository/Chat_TeamRepository.java](/src/main/java/net/ausiasmarch/rollinter/repository/Chat_TeamRepository.java) | Java | 20 | 0 | 15 | 35 |
| [src/main/java/net/ausiasmarch/rollinter/repository/CommentRepository.java](/src/main/java/net/ausiasmarch/rollinter/repository/CommentRepository.java) | Java | 22 | 0 | 16 | 38 |
| [src/main/java/net/ausiasmarch/rollinter/repository/CoordinatesRepository.java](/src/main/java/net/ausiasmarch/rollinter/repository/CoordinatesRepository.java) | Java | 11 | 0 | 9 | 20 |
| [src/main/java/net/ausiasmarch/rollinter/repository/ReactionRepository.java](/src/main/java/net/ausiasmarch/rollinter/repository/ReactionRepository.java) | Java | 19 | 0 | 18 | 37 |
| [src/main/java/net/ausiasmarch/rollinter/repository/RouteRepository.java](/src/main/java/net/ausiasmarch/rollinter/repository/RouteRepository.java) | Java | 16 | 0 | 13 | 29 |
| [src/main/java/net/ausiasmarch/rollinter/repository/TeamRepository.java](/src/main/java/net/ausiasmarch/rollinter/repository/TeamRepository.java) | Java | 17 | 0 | 10 | 27 |
| [src/main/java/net/ausiasmarch/rollinter/repository/UserRepository.java](/src/main/java/net/ausiasmarch/rollinter/repository/UserRepository.java) | Java | 22 | 0 | 20 | 42 |
| [src/main/java/net/ausiasmarch/rollinter/repository/UsertypeRepository.java](/src/main/java/net/ausiasmarch/rollinter/repository/UsertypeRepository.java) | Java | 5 | 0 | 3 | 8 |
| [src/main/java/net/ausiasmarch/rollinter/service/AuthService.java](/src/main/java/net/ausiasmarch/rollinter/service/AuthService.java) | Java | 130 | 0 | 18 | 148 |
| [src/main/java/net/ausiasmarch/rollinter/service/Chat_TeamService.java](/src/main/java/net/ausiasmarch/rollinter/service/Chat_TeamService.java) | Java | 113 | 8 | 37 | 158 |
| [src/main/java/net/ausiasmarch/rollinter/service/CommentService.java](/src/main/java/net/ausiasmarch/rollinter/service/CommentService.java) | Java | 119 | 23 | 40 | 182 |
| [src/main/java/net/ausiasmarch/rollinter/service/CoordinatesService.java](/src/main/java/net/ausiasmarch/rollinter/service/CoordinatesService.java) | Java | 84 | 11 | 45 | 140 |
| [src/main/java/net/ausiasmarch/rollinter/service/ReactionService.java](/src/main/java/net/ausiasmarch/rollinter/service/ReactionService.java) | Java | 131 | 17 | 35 | 183 |
| [src/main/java/net/ausiasmarch/rollinter/service/RouteService.java](/src/main/java/net/ausiasmarch/rollinter/service/RouteService.java) | Java | 138 | 3 | 41 | 182 |
| [src/main/java/net/ausiasmarch/rollinter/service/TeamService.java](/src/main/java/net/ausiasmarch/rollinter/service/TeamService.java) | Java | 185 | 4 | 52 | 241 |
| [src/main/java/net/ausiasmarch/rollinter/service/UserService.java](/src/main/java/net/ausiasmarch/rollinter/service/UserService.java) | Java | 242 | 3 | 57 | 302 |
| [src/main/java/net/ausiasmarch/rollinter/service/UsertypeService.java](/src/main/java/net/ausiasmarch/rollinter/service/UsertypeService.java) | Java | 63 | 2 | 17 | 82 |
| [src/main/resources/application.properties](/src/main/resources/application.properties) | Java Properties | 18 | 5 | 6 | 29 |
| [src/test/java/net/ausiasmarch/rollinter/RollinterApplicationTests.java](/src/test/java/net/ausiasmarch/rollinter/RollinterApplicationTests.java) | Java | 9 | 0 | 5 | 14 |

[Summary](results.md) / Details / [Diff Summary](diff.md) / [Diff Details](diff-details.md)