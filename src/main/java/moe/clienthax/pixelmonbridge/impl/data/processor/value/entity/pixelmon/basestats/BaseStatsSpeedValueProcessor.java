package moe.clienthax.pixelmonbridge.impl.data.processor.value.entity.pixelmon.basestats;

import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.common.data.processor.common.AbstractSpongeValueProcessor;
import org.spongepowered.common.data.value.immutable.ImmutableSpongeValue;
import org.spongepowered.common.data.value.mutable.SpongeValue;

import java.util.Optional;

public class BaseStatsSpeedValueProcessor extends AbstractSpongeValueProcessor<EntityPixelmon, Integer, Value<Integer>> {

    public BaseStatsSpeedValueProcessor() {
        super(EntityPixelmon.class, PixelmonDataKeys.POKEMON_BASESTATS_SPEED);
    }

    @Override
    protected Value<Integer> constructValue(Integer actualValue) {
        return new SpongeValue<>(getKey(), actualValue);
    }

    @Override
    protected boolean set(EntityPixelmon container, Integer value) {
        container.baseStats.speed = value;
        return true;
    }

    @Override
    protected Optional<Integer> getVal(EntityPixelmon container) {
        return Optional.of(container.baseStats.speed);
    }

    @Override
    protected ImmutableValue<Integer> constructImmutableValue(Integer value) {
        return new ImmutableSpongeValue<>(getKey(), value);
    }

    @Override
    public DataTransactionResult removeFrom(ValueContainer<?> container) {
        return DataTransactionResult.failNoData();
    }
}
