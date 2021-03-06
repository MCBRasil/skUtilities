package uk.tim740.skUtilities.conversion;

import org.bukkit.event.Event;

import javax.annotation.Nullable;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class ExprAsciiToTxt extends SimpleExpression<String>{
	private Expression<Number> number;

	@Override
	public Class<? extends String> getReturnType() {
		return String.class;
	}
	
	@Override
	public boolean isSingle() {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] arg0, int arg1, Kleenean arg2, ParseResult arg3) {
		this.number = (Expression<Number>) arg0[0];
		return true;
	}

	@Override
	public String toString(@Nullable Event arg0, boolean arg1) {
		return this.getClass().getName();
	}

	@Override
	@Nullable
	protected String[] get(Event arg0) {
		return new String[]{Character.toString ((char) Integer.parseInt(this.number.getSingle(arg0).toString()))};
	}
}
