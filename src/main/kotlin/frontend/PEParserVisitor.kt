package main.kotlin.frontend

import antlr.PEParserBaseVisitor
import antlr.PEParser.*

class PEParserVisitor : PEParserBaseVisitor<ASTNode>() {

    override fun visitProgram(ctx: ProgramContext): FunctionNode {
        return visitFunction(ctx.function())
    }

    override fun visitFunction(ctx: FunctionContext): FunctionNode {
        val params = visitParam_list(ctx.param_list())
        val expr = super.visit(ctx.expr()) as ExpressionNode

        return FunctionNode(params.identifiers, expr)
    }

    override fun visitParam_list(ctx: Param_listContext): ParameterListNode {
        return ParameterListNode(
                ctx.IDENT().map { IdentifierNode(it.text) }
        )
    }

    override fun visitIdentifier(ctx: IdentifierContext): IdentifierNode {
        return IdentifierNode(ctx.text)
    }

    override fun visitAddExpression(ctx: AddExpressionContext): AddExpressionNode {
        val left = super.visit(ctx.left) as ExpressionNode
        val right = super.visit(ctx.right) as ExpressionNode
        return AddExpressionNode(left, right)
    }

    override fun visitMulExpression(ctx: MulExpressionContext): MulExpressionNode {
        val left = super.visit(ctx.left) as ExpressionNode
        val right = super.visit(ctx.right) as ExpressionNode
        return MulExpressionNode(left, right)
    }

    override fun visitBracketedExpression(ctx: BracketedExpressionContext): NestedExpressionNode {
        val expr = super.visit(ctx.expr()) as ExpressionNode
        return NestedExpressionNode(expr)
    }
}