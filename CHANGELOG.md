## 2.0pre2
- Frames' code has been almost entirely redone; they no longer connect to non-solid blocks or blocks with smaller models.
- Layers now have a rotate/mirror method -- this should allow them to properly save and load when put into structures.
- Block descriptions now use "Left Control" instead of "Left Shift" to show their tooltips.
   - I had noticed that when trying to fast-transfer them to containers you would sort of get flashbanged.
- Fixed HangingEntityMixin - should now have a higher priority + survive while in Frames
- Columns now have proper waterlogging - if their layers have not been removed, they can not be waterlogged. If their layers are replaced, they will lose any existing waterlogged state.
- Added Hammer compatibility with Another Furniture.
- Removed buggy "Paintings surviving in Frames" mechanic