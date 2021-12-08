package main.kotlin.frontend

interface ASTNode

data class FunctionNode(val identifiers: List<IdentifierNode>, val expr: ExpressionNode) : ASTNode

data class IdentifierNode(val ident: String): ExpressionNode {
    override fun toString(): String {
        return ident
    }
}

data class ParameterListNode(val identifiers: List<IdentifierNode>): ASTNode

interface ExpressionNode: ASTNode
data class AddExpressionNode(val left: ExpressionNode, val right: ExpressionNode): ExpressionNode
data class MulExpressionNode(val left: ExpressionNode, val right: ExpressionNode): ExpressionNode
data class NestedExpressionNode(val expr: ExpressionNode): ExpressionNode


