# Contributing to MLS-JAVA-BACKEND

我们秉持着感谢的态度欢迎你来为 MLS-JAVA-BACKEND 做出贡献，无论是提交 issue 还是提交 PR 都是对 MLS-JAVA-BACKEND 最好的贡献

以下是为 MLS-JAVA-BACKEND 做出代码贡献的步骤和规范。

## 代码贡献步骤

> 在代码贡献之前，请确保您的本地环境正确
> 
> 本项目的后端部分使用的是 Maven 作为构建工具，JDK 版本为 17
> 
> 本项目的管理端部分使用的是 pnpm 作为包管理工具，node 版本为 >=18

**0. 提交 issue**

如果是重大变更或者是想要添加新功能，请按照对应的模板提出 issue，如果是对代码的优化或者是 bug 修复，请直接提交 PR.

**1. Fork 仓库**

点击 Fork 按钮，将本仓库 Fork 到自己的 GitHub 账号下.

**2. 克隆仓库**

```bash
git clone https://github.com/{username}/Java-Backend.git
```
**3. 创建分支**

请按照分支命名规范来命名你的分支，对于分支命名规范，请参阅 [命名提交规范](#命名提交规范) 部分.

分支名应该为 `type/description`，例如 `feat/posts-options`，`fix/xxx-bug`，`docs/xxx` 等等.

```bash
git checkout -b {BRANCH_NAME}
```

**4. 安装依赖**

请使用您喜欢的代码编辑器打开项目，然后安装依赖。

对于管理端部分，我们使用了 pnpm 作为包管理工具，所以你需要安装 pnpm.

执行以下命令安装依赖
```bash
cd MLS-Console
pnpm install
```
对于后端部分，我们使用了 Maven 作为构建工具，因此你需要安装 Maven.

在代码编辑器中使用集成工具安装依赖.

**5. 开发**

**6. 提交代码**

请按照 commit 规范对代码进行提交，commit 规范请参阅 [命名提交规范](#命名提交规范) 部分.

如果你的代码还缺乏部分尚未完成，请你点击 Draft Pull Request，而不是 Open Pull Request.

对于您的 commit 提交，我们建议您使用 GPG 签名，这样可以保证您的代码不会被篡改.
```bash
git add .
git commit -m "<type>(<scope>): <subject>"
git push origin {BRANCH_NAME}
```

**7. 提交 PR**

在 GitHub 上提交 PR. 点击 `Compare & Pull Request` 按钮，填写 PR 信息，然后点击 `Create Pull Request` 按钮.

PR 的标题请紧随您的分支名称，遵循 [命名提交规范](#命名提交规范) 的规范.

然后请耐心等待 CI 的结果，如果 CI 通过，那么您的 PR 将会被 review，如果 review 提出了修改意见（Change Request），可以在本地修改后再次提交，然后再次 push 到远程仓库，PR 会自动更新.

## 本项目的目录结构

```
├─MLS-Common // 后端代码工具类部分
├─MLS-Console // 前端管理端部分的代码
├─MLS-System // 后端主体代码部分，涉及 entity、repository、service 等数据部分
└─MLS-Web // 后端接口代码部分，涉及 controller、security 等接口部分
```

## 命名提交规范

本项目的 commit message、分支名称、PR 标题、PR 描述等参考了 [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) 的规范.

中文部分可参考 [Conventional Commits 中文版](https://www.conventionalcommits.org/zh-hans/v1.0.0/).

```
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]

```
### Type 说明

fix：修复程序已发现或者是潜在的 bug

feat：新增功能

build：构建系统或者是外部依赖项的更改

chore：不修改业务代码情况下对其余部分的修改，例如修改构建流程、工具配置等

ci：对 CI 配置文件和脚本的修改

docs：对文档的修改

refactor：代码重构，在不修改业务逻辑的情况下对代码进行的变动，例如对代码的结构修改、变量名、方法名称修改等

style：对代码风格的修改，例如缩进、空格、换行等

perf：优化相关，对程序的性能进行优化

test：测试相关，对测试用例的变动

### Scope 说明

Scope 用于描述 commit 影响的范围，可以以模块、代码层级或者文件的形式进行描述，例如 `feat(posts): add new post`，`fix(posts): fix a bug in posts` 等等.

该选项并非必选项，如果你的 commit 影响了多个模块，那么可以省略该选项.

### Description 说明

Description 用于描述 commit 的主要内容，是 commit message 的主体部分，是必选项.

请确保您的 commit message 能够清晰地描述您的修改.

### Body 说明

Body 用于描述 commit 的详细内容，是 commit message 的主体部分，是可选项.

如果您的 commit message 能够清晰地描述您的修改，那么您可以省略该选项.

### Footer 说明

Footer 用于描述一些额外的信息，例如对 issue 的关闭、对 breaking change 的描述等等，是 commit message 的主体部分，是可选项.

如果您的代码中包含了 breaking change，那么您应该在该选项中进行描述，例如 `BREAKING CHANGE: xxx`，如果您的代码中没有包含 breaking change，那么您可以省略该选项.

## 版本号约定

本项目的版本号遵循 [Semantic Versioning](https://semver.org/lang/zh-CN/) 的规范.

版本号格式为 `MAJOR.MINOR.PATCH`，例如 `1.0.0`，`2.1.0` 等等.

先行版本号和构建元数据可以在版本号后面添加，例如 `1.0.0-alpha.1`，`2.1.0+20211001` 等等.

先行版本号的各个含义如下：

alpha：内部测试版本，不稳定，可能存在大量 bug，不建议使用，该版本号仅进行版本号发行，并不会进行实际的代码发行，如果您想要体验该版本，请自行编译代码

beta：公测版本，相对稳定，可能存在少量 bug，不建议在生产环境中使用，该版本号会进行版本号发行和实际的代码发行，可供自行部署使用，您可以在 GitHub 的 issue 中提交 bug

rc：候选版本，相对稳定，可能存在少量 bug，不建议在生产环境中使用，相对于 beta 版本，rc 版本的 bug 更少，该版本号会进行版本号发行和实际的代码发行，可供自行部署使用，您可以在 GitHub 的 issue 中提交 bug

> 请注意，以上预发布版本的代码由于不稳定，可能存在各种问题，请您理性看待，并注意自行备份数据，我们不会对您的数据丢失负责
