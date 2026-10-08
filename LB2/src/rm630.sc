;;; Sierra Script 1.0 - (do not remove this comment)
(script# 630)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use n027)
(use MuseumRgn)
(use Inset)
(use PolyPath)
(use CueObj)
(use ForwardCounter)
(use n958)
(use Timer)
(use Sound)
(use Cycle)
(use InvI)
(use View)
(use Obj)

(public
	rm630 0
	labDoor 2
)

(local
	local0
	local1
	local2
)
(instance rm630 of LBRoom
	(properties
		sel_20 {rm630}
		sel_213 21
		sel_408 630
		sel_410 610
		sel_108 105
	)
	
	(method (sel_110)
		(gEgo sel_110: sel_320: 0 sel_585: 827 sel_51: 4)
		(self sel_414: 90)
		(if (not (proc0_2 4))
			(cond 
				((not (proc0_10 -20222)) 0)
				((not (proc0_10 4880)) (proc0_4 18))
				(else 0)
			)
		)
		(switch gGSel_40
			(sel_410
				(gEgo sel_349: 0 sel_253: 270)
			)
			(else 
				(gEgo sel_584: 1 sel_153: 202 158)
				(= global123 4)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(proc958_0 132 631 632 633 634)
		(labDoor sel_110:)
		(trunk sel_311: 1 4 8 sel_110:)
		(fridgeDoor sel_311: 4 sel_110:)
		(bag sel_110:)
		(if (== ((Inv sel_64: 14) sel_166?) 630)
			(snakeOil sel_110: sel_311: 4 1 8)
		)
		(if
			(or
				(and (== global123 3) (proc0_10 4104))
				(>= global123 4)
			)
			(proc958_0 128 630 631 633 632 634 635)
			(proc958_0 132 631 632 633 634 85 635 636)
			(boxFrontLeft sel_110:)
			(assortedBoxes sel_110:)
			(meatLocker sel_110:)
			(leftShelves sel_110:)
			(cabinet sel_110:)
			(crate2 sel_110:)
			(crate3 sel_110:)
			(poster sel_110:)
			(assortedTools sel_110:)
			(canister sel_110:)
			(light sel_110:)
			(rightShelf sel_110:)
			(desk sel_110:)
			(crate1 sel_1: (if (proc0_2 119) 105 else 138) sel_110:)
			(if (proc0_2 12)
				(trunk sel_1: 299 sel_156: 1 sel_313:)
				(trunkLid sel_110: sel_311: 1 4 8)
				(if (proc0_2 13)
					(trunkLid sel_156: (trunkLid sel_246:) sel_313:)
				)
			else
				(proc958_0 132 635 636)
			)
			(if (proc0_2 14)
				(fridgeDoor sel_156: (fridgeDoor sel_246:) sel_313:)
			)
			(if (and (not (proc0_2 12)) (not (proc0_2 60)))
				(ferret sel_110:)
				(Load rsSOUND 637)
				(ferretTimer sel_162: ferret (Random 5 30))
			)
		else
			(gGameMusic2 sel_40: 520 sel_3: -1 sel_99: 1 sel_39:)
			(crate1 sel_110:)
			(olympia sel_110:)
			(= local2 1)
		)
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			((== sel_142 sGoTunnel))
			(
			(and (proc0_1 gEgo 4) (== (crate1 sel_1?) 105)) (self sel_146: sGoTunnel))
		)
	)
	
	(method (sel_111)
		(ferretTimer sel_111: sel_81:)
		(gIconBar sel_233: 7)
		(gGameMusic2 sel_170:)
		(super sel_111:)
	)
	
	(method (sel_145)
		(sPlayMusic sel_111:)
		(gGameMusic2 sel_170:)
	)
)

(instance sGoTunnel of Script
	(properties
		sel_20 {sGoTunnel}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_253: 0 self)
			)
			(1
				(gEgo sel_312: MoveTo 141 138 self)
			)
			(2
				(proc0_4 119)
				(global2 sel_399: 666)
				(self sel_111:)
			)
		)
	)
)

(instance sKickedOut of Script
	(properties
		sel_20 {sKickedOut}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_253: 180 self)
			)
			(1 (= sel_139 60))
			(2
				(gLb2Messager sel_295: 23 0 6)
				(= sel_136 1)
			)
			(3
				(proc0_3 50)
				(labDoor sel_300: 4)
				(self sel_111:)
			)
		)
	)
)

(instance sOpenFridge of Script
	(properties
		sel_20 {sOpenFridge}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_2: 633
					sel_155: 0
					sel_156: 0
					sel_244: 12
					sel_161: CT 1 1 self
				)
			)
			(1
				(gEgo sel_161: End)
				(fridgeDoor sel_161: End self)
				(sFX sel_40: 631 sel_99: 5 sel_39:)
			)
			(2
				(fridgeDoor sel_313:)
				(gEgo sel_161: Beg self)
			)
			(3
				(gEgo sel_3: 1 sel_585: 827 sel_51: 4)
				(proc0_3 14)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sCloseFridge of Script
	(properties
		sel_20 {sCloseFridge}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_2: 633
					sel_155: 0
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(1
				(gEgo sel_161: Beg)
				(fridgeDoor sel_161: Beg self)
			)
			(2
				(sFX sel_40: 632 sel_99: 5 sel_39:)
				(fridgeDoor sel_313:)
				(proc0_4 14)
				(gEgo sel_3: 1 sel_585: 827 sel_51: 4)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sFerretSniff of Script
	(properties
		sel_20 {sFerretSniff}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(ferret
					sel_155: 5
					sel_156: 0
					sel_153: 116 151
					sel_161: Walk
					sel_312: MoveTo 216 149 self
				)
			)
			(1
				(ferret
					sel_155: 2
					sel_156: 0
					sel_63: 11
					sel_244: 6
					sel_161: End self
				)
			)
			(2 (= sel_139 30))
			(3 (ferret sel_161: Beg self))
			(4
				(ferret
					sel_155: 5
					sel_161: Walk
					sel_244: 4
					sel_312: MoveTo 272 143 self
				)
			)
			(5
				(ferret
					sel_155: 0
					sel_156: 0
					sel_244: 6
					sel_161: ForwardCounter 2 self
				)
			)
			(6
				(sFX sel_40: 637 sel_99: 1 sel_39:)
				(= sel_139 30)
			)
			(7
				(ferret
					sel_155: 5
					sel_161: Walk
					sel_312: MoveTo 280 142 self
				)
			)
			(8
				(ferret sel_155: 3 sel_156: 0 sel_161: End self)
			)
			(9 (ferret sel_161: Beg self))
			(10
				(ferret sel_155: 2 sel_156: 0 sel_161: End self)
			)
			(11
				(ferret
					sel_153: 268 142
					sel_155: 1
					sel_156: (ferret sel_246:)
					sel_161: Beg self
				)
			)
			(12
				(ferret
					sel_155: 4
					sel_244: 4
					sel_161: Walk
					sel_312: MoveTo 212 153 self
				)
			)
			(13
				(ferret sel_63: -1 sel_312: MoveTo 158 164 self)
			)
			(14
				(proc0_3 60)
				(ferret sel_313:)
				(self sel_111:)
			)
		)
	)
)

(instance sUnlockTrunk of Script
	(properties
		sel_20 {sUnlockTrunk}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(fridgeDoor sel_311: 0)
				(snakeOil sel_311: 0)
				(labDoor sel_311: 0)
				(gEgo sel_312: PolyPath 258 144 self)
			)
			(1
				(gEgo
					sel_2: 633
					sel_155: 1
					sel_156: 0
					sel_63: 12
					sel_244: 12
					sel_161: CT 3 1 self
				)
			)
			(2
				(gEgo sel_161: CT 4 1 self)
				(trunk sel_1: 314)
			)
			(3
				(gEgo sel_161: CT 5 1 self)
				(trunk sel_1: 305)
			)
			(4
				(gEgo sel_161: CT 6 1 self)
				(trunk sel_1: 299)
			)
			(5
				(trunk sel_156: 1)
				(trunkLid
					sel_110:
					sel_311: 1 4 8
					sel_244: 12
					sel_161: End
				)
				(sFX sel_40: 633 sel_99: 5 sel_39:)
				(gEgo sel_161: End self)
			)
			(6
				(trunk sel_313:)
				(trunkLid sel_313:)
				(proc0_3 13)
				(gGame sel_588:)
				(gIconBar sel_233: 0)
				(= sel_137 (if (HaveMouse) 6 else 12))
			)
			(7
				(gGame sel_587:)
				(sFX sel_40: 635 sel_99: 1 sel_39:)
				(gEgo sel_2: 634 sel_155: 0 sel_156: 0 sel_161: End self)
			)
			(8
				(gEgo sel_155: 1 sel_156: 0 sel_161: End self)
			)
			(9
				(sFX sel_167:)
				(= sel_139 120)
			)
			(10
				(= global145 1)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sInsertMeat of Script
	(properties
		sel_20 {sInsertMeat}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_155: 2 sel_156: 0 sel_161: End self)
			)
			(1
				(gEgo
					sel_155: 1
					sel_156: (gEgo sel_246:)
					sel_161: Beg self
				)
			)
			(2
				(gEgo sel_585: 827 sel_3: 0 sel_351: 9 sel_51: 4)
				((ScriptID 21 1) sel_57: 778)
				(sFX2 sel_40: 636 sel_99: 1 sel_39:)
				(= sel_139 120)
			)
			(3
				(bugsWithMeat sel_110: sel_161: End self)
			)
			(4
				(bugsWithMeat
					sel_2: 635
					sel_155: 0
					sel_156: 0
					sel_153: 260 146
					sel_161: Fwd
					sel_244: 4
					sel_53: 4
					sel_312: MoveTo 157 157 self
				)
			)
			(5
				(sFX2 sel_170:)
				(bugsWithMeat sel_111:)
				(proc0_3 12)
				(proc0_3 171)
				(proc0_3 134)
				(MuseumRgn sel_645:)
				(fridgeDoor sel_311: 4)
				(snakeOil sel_311: 4 1 8)
				(labDoor sel_311: 4 18)
				(ferretTimer sel_111: sel_81:)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sOpenTrunk of Script
	(properties
		sel_20 {sOpenTrunk}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_2: 633
					sel_155: 1
					sel_156: 0
					sel_63: 12
					sel_244: 12
					sel_161: CT 6 1 self
				)
			)
			(1
				(gEgo sel_161: End self)
				(trunkLid sel_161: End)
				(sFX sel_40: 633 sel_99: 5 sel_39:)
			)
			(2
				(gEgo sel_156: 5 sel_161: Beg self)
			)
			(3
				(proc0_3 13)
				(trunkLid sel_313:)
				(gEgo sel_585: 827 sel_3: 0 sel_153: 258 144 sel_51: 4)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sCloseTrunk of Script
	(properties
		sel_20 {sCloseTrunk}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_2: 633
					sel_155: 1
					sel_156: 0
					sel_63: 12
					sel_244: 12
					sel_161: CT 5 1 self
				)
			)
			(1
				(gEgo sel_156: (gEgo sel_246:) sel_161: CT 9 -1 self)
			)
			(2
				(gEgo sel_161: CT 6 -1 self)
				(trunkLid sel_161: Beg)
				(sFX sel_40: 634 sel_99: 5 sel_39:)
			)
			(3 (gEgo sel_161: Beg self))
			(4
				(proc0_4 13)
				(trunkLid sel_313:)
				(gEgo sel_585: 827 sel_3: 0 sel_153: 258 144 sel_51: 4)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sPlayMusic of Script
	(properties
		sel_20 {sPlayMusic}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(if (proc0_2 87)
					(= sel_136 1)
				else
					(gGameMusic2 sel_40: 4 sel_3: 1 sel_99: 1 sel_39: self)
					(sFX sel_40: 85 sel_3: 1 sel_99: 5 sel_39:)
					(proc0_3 87)
				)
			)
			(1
				(gGameMusic2 sel_40: 6 sel_3: -1 sel_99: 1 sel_39:)
			)
		)
	)
)

(instance labDoor of Door
	(properties
		sel_20 {labDoor}
		sel_1 277
		sel_0 73
		sel_213 20
		sel_303 244
		sel_304 143
		sel_2 630
		sel_3 4
		sel_60 9
		sel_14 16
		sel_589 610
		sel_597 287
		sel_598 139
		sel_599 0
		sel_600 0
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if
					(and
						(global2 sel_142?)
						(!= (global2 sel_142?) sKickedOut)
					)
					0
				else
					(super sel_300: param1)
				)
			)
			(else  (super sel_300: param1))
		)
	)
	
	(method (sel_145)
		(super sel_145: &rest)
		(if (== sel_29 0)
			(if local2
				(global2 sel_146: sKickedOut)
			else
				(gIconBar sel_177: 7)
			)
			(= sel_60 8)
		else
			(= sel_60 9)
		)
	)
	
	(method (sel_606)
		(super sel_606: 265 132 273 137 269 141 261 135)
	)
)

(instance ferretTimer of Timer
	(properties
		sel_20 {ferretTimer}
	)
)

(instance trunk of Prop
	(properties
		sel_20 {trunk}
		sel_1 319
		sel_0 144
		sel_213 1
		sel_303 258
		sel_304 144
		sel_2 631
		sel_3 1
		sel_60 10
		sel_14 16401
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(1
					(if (and (proc0_2 12) (trunkLid sel_4?))
						(gGame sel_87: 1 147)
						(global2 sel_422: inBones)
					else
						(gLb2Messager sel_295: 1 1)
					)
				)
				(8
					(if (and (proc0_2 12) (trunkLid sel_4?))
						(gGame sel_87: 1 147)
						(global2 sel_422: inBones)
					else
						(gLb2Messager sel_295: 1 8)
					)
				)
				(4
					(cond 
						((and (proc0_2 12) (not (trunkLid sel_4?)))
							(if (MuseumRgn sel_646:)
								(global2 sel_146: sOpenTrunk)
							else
								(return 1)
							)
						)
						((and (proc0_2 12) (trunkLid sel_4?)) (global2 sel_146: sCloseTrunk))
						((global2 sel_142?) 0)
						(else (gLb2Messager sel_295: 1 4 5))
					)
				)
				(18
					(if (not (global2 sel_142?))
						(cond 
							((proc0_2 12) (gLb2Messager sel_295: 1 18 7))
							((MuseumRgn sel_646:) (global2 sel_146: sUnlockTrunk))
							(else (return 1))
						)
					)
				)
				(19
					(if (!= (trunk sel_1?) 319)
						(global2 sel_146: sInsertMeat)
					else
						(super sel_300: param1)
					)
				)
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance trunkLid of Prop
	(properties
		sel_20 {trunkLid}
		sel_1 299
		sel_0 128
		sel_213 1
		sel_303 258
		sel_304 144
		sel_2 631
		sel_3 2
		sel_60 10
		sel_14 16401
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(1
					(if (and (proc0_2 12) (trunkLid sel_4?))
						(gGame sel_87: 1 147)
						(global2 sel_422: inBones)
					else
						(gLb2Messager sel_295: 1 1)
					)
				)
				(4
					(cond 
						((and (proc0_2 12) (not (trunkLid sel_4?)))
							(if (MuseumRgn sel_646:)
								(global2 sel_146: sOpenTrunk)
							else
								(return 1)
							)
						)
						((and (proc0_2 12) (trunkLid sel_4?)) (global2 sel_146: sCloseTrunk))
					)
				)
				(19
					(global2 sel_146: sInsertMeat)
				)
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance fridgeDoor of Prop
	(properties
		sel_20 {fridgeDoor}
		sel_1 43
		sel_0 99
		sel_213 4
		sel_303 76
		sel_304 146
		sel_2 631
		sel_14 16385
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (self sel_4?)
					(if (or (gEgo sel_238: 9) (proc0_2 12))
						(gLb2Messager sel_295: 4 1 3)
					else
						(gEgo sel_312: PolyPath sel_303 sel_304 self)
					)
				else
					(gLb2Messager sel_295: 4 1 1)
				)
			)
			(4
				(if (not (global2 sel_142?))
					(if (self sel_4?)
						(global2 sel_146: sCloseFridge)
					else
						(global2 sel_146: sOpenFridge)
					)
				)
			)
			(else  (super sel_300: param1))
		)
	)
	
	(method (sel_145)
		(global2 sel_422: inMeat)
	)
)

(instance bag of View
	(properties
		sel_20 {bag}
		sel_1 21
		sel_0 27
		sel_213 3
		sel_2 630
		sel_3 3
		sel_14 16385
	)
)

(instance crate1 of View
	(properties
		sel_20 {crate1}
		sel_1 138
		sel_0 141
		sel_213 11
		sel_2 630
		sel_3 6
		sel_14 16385
	)
)

(instance ferret of Actor
	(properties
		sel_20 {ferret}
		sel_1 116
		sel_0 151
		sel_2 632
		sel_3 5
		sel_14 16384
		sel_244 3
		sel_51 4
		sel_53 3
	)
	
	(method (sel_57)
		(super sel_57:)
		(if (and (!= (trunk sel_1?) 319) (not local0))
			(= local0 1)
			(self
				sel_146: 0
				sel_155: 4
				sel_63: -1
				sel_244: 4
				sel_53: 6
				sel_161: Walk
				sel_312: MoveTo 158 164 self
			)
		)
	)
	
	(method (sel_300 param1)
		(switch param1
			(6
				(switch (global2 sel_422: (ScriptID 20 0))
					(259
						(if (proc27_0 12 global298)
							(gLb2Messager sel_295: 1 6 1 0 0 1894)
						else
							(gLb2Messager sel_295: 1 6 4 0 0 1894)
							(proc27_1 12 @global298)
						)
					)
					(260
						(if (proc27_0 12 global299)
							(gLb2Messager sel_295: 1 6 1 0 0 1894)
						else
							(gLb2Messager sel_295: 1 6 5 0 0 1894)
							(proc27_1 12 @global299)
						)
					)
					(265
						(if (proc27_0 12 global304)
							(gLb2Messager sel_295: 1 6 1 0 0 1894)
						else
							(gLb2Messager sel_295: 1 6 10 0 0 1894)
							(proc27_1 12 @global304)
						)
					)
					(266
						(if (proc27_0 12 global305)
							(gLb2Messager sel_295: 1 6 1 0 0 1894)
						else
							(gLb2Messager sel_295: 1 6 11 0 0 1894)
							(proc27_1 12 @global305)
						)
					)
					(270
						(if (proc27_0 12 global309)
							(gLb2Messager sel_295: 1 6 1 0 0 1894)
						else
							(gLb2Messager sel_295: 1 6 15 0 0 1894)
							(proc27_1 12 @global309)
						)
					)
					(781
						(if (proc27_0 12 global333)
							(gLb2Messager sel_295: 1 6 1 0 0 1894)
						else
							(gLb2Messager sel_295: 1 6 39 0 0 1894)
							(proc27_1 12 @global333)
						)
					)
					(785
						(if (proc27_0 12 global337)
							(gLb2Messager sel_295: 1 6 1 0 0 1894)
						else
							(gLb2Messager sel_295: 1 6 43 0 0 1894)
							(proc27_1 12 @global337)
						)
					)
					(800
						(if (proc27_0 12 global352)
							(gLb2Messager sel_295: 1 6 1 0 0 1894)
						else
							(gLb2Messager sel_295: 1 6 58 0 0 1894)
							(proc27_1 12 @global352)
						)
					)
					(else 
						(gLb2Messager sel_295: 1 6 81 0 0 1894)
					)
				)
			)
			(41
				(gLb2Messager sel_295: 1 41 0 0 0 1894)
			)
			(8
				(gLb2Messager sel_295: 1 8 0 0 0 1894)
			)
			(19
				(gLb2Messager sel_295: 1 19 0 0 0 1894)
			)
			(24
				(gLb2Messager sel_295: 1 24 0 0 0 1894)
			)
			(25
				(gLb2Messager sel_295: 1 25 0 0 0 1894)
			)
			(23
				(gLb2Messager sel_295: 1 23 0 0 0 1894)
			)
			(2
				(gLb2Messager sel_295: 1 2 0 0 0 1894)
			)
			(4
				(gLb2Messager sel_295: 1 4 0 0 0 1894)
			)
			(1
				(gLb2Messager sel_295: 1 1 0 0 0 1894)
			)
			(else 
				(gLb2Messager sel_295: 1 0 0 0 0 1894)
			)
		)
	)
	
	(method (sel_145)
		(if local0
			(= local0 0)
			(self sel_111:)
		else
			(self sel_146: sFerretSniff)
		)
	)
)

(instance bugsWithMeat of Actor
	(properties
		sel_20 {bugsWithMeat}
		sel_1 275
		sel_0 143
		sel_2 631
		sel_3 3
		sel_60 11
		sel_14 16400
	)
)

(instance olympia of View
	(properties
		sel_20 {olympia}
		sel_1 273
		sel_0 151
		sel_2 630
		sel_3 5
		sel_14 16385
	)
)

(instance snakeOil of View
	(properties
		sel_20 {snakeOil}
		sel_1 288
		sel_0 123
		sel_82 20
		sel_303 252
		sel_304 152
		sel_2 61
		sel_60 10
		sel_14 16401
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gLb2Messager sel_295: 33 1 9 0 0 15)
			)
			(8
				(gLb2Messager sel_295: 33 8 0 0 0 15)
			)
			(4
				(gEgo sel_350: 14)
				((ScriptID 21 0) sel_57: 783)
				(self sel_111:)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inMeat of Inset
	(properties
		sel_20 {inMeat}
		sel_2 630
		sel_1 33
		sel_0 66
		sel_570 1
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(gEgo sel_350: 9)
				((ScriptID 21 0) sel_57: 778)
				(self sel_111:)
			)
			(1
				(gLb2Messager sel_295: 22 1 0 0 0 15)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inBones of Inset
	(properties
		sel_20 {inBones}
		sel_2 630
		sel_3 1
		sel_1 258
		sel_0 108
		sel_570 1
		sel_213 2
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(proc0_3 12)
		(proc0_3 171)
		(proc0_3 134)
		(proc958_0 132 4 6)
		(= local1 0)
		(global2 sel_146: sPlayMusic)
	)
	
	(method (sel_111)
		(super sel_111: &rest)
		(if (not local1) (gGameMusic2 sel_170: global2))
	)
	
	(method (sel_300 param1)
		(switch param1
			(8
				(if (gEgo sel_238: 7)
					(gLb2Messager sel_295: 2 8)
				else
					(= local1 1)
					(global2 sel_422: inWatch)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inWatch of Inset
	(properties
		sel_20 {inWatch}
		sel_2 630
		sel_3 2
		sel_1 259
		sel_0 109
		sel_570 1
		sel_213 22
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(= local1 0)
	)
	
	(method (sel_111)
		(super sel_111: &rest)
		(if (not local1) (gGameMusic2 sel_170: global2))
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(= local1 1)
				(global2 sel_422: inWatchOpen)
			)
			(1
				(gLb2Messager sel_295: 22 1 4)
			)
			(8
				(gLb2Messager sel_295: 22 1 4)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inWatchOpen of Inset
	(properties
		sel_20 {inWatchOpen}
		sel_2 630
		sel_3 2
		sel_4 1
		sel_1 259
		sel_0 109
		sel_570 1
		sel_213 22
	)
	
	(method (sel_111 param1)
		(super sel_111:)
		(gGameMusic2 sel_170: global2)
		(return
			(if
				(and
					(== global123 3)
					argc
					param1
					(not (proc0_10 4880))
				)
				((ScriptID 22 0) sel_57: 4880 global2)
				(gGame sel_87: 1 168)
				((ScriptID 90 2) sel_182: -2)
				(++ global111)
			else
				0
			)
		)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(gEgo sel_350: 7)
				((ScriptID 21 0) sel_57: 776)
				(gGame sel_87: 1 148)
				(self sel_111: 1)
			)
			(1
				(gLb2Messager sel_295: 26 8 0 0 0 15)
			)
			(8
				(gLb2Messager sel_295: 26 8 0 0 0 15)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance boxFrontLeft of Feature
	(properties
		sel_20 {boxFrontLeft}
		sel_1 61
		sel_0 167
		sel_213 6
		sel_6 140
		sel_8 194
		sel_9 122
		sel_301 40
	)
)

(instance assortedBoxes of Feature
	(properties
		sel_20 {assortedBoxes}
		sel_1 221
		sel_0 170
		sel_213 7
		sel_6 152
		sel_7 123
		sel_8 189
		sel_9 319
		sel_301 40
	)
)

(instance meatLocker of Feature
	(properties
		sel_20 {meatLocker}
		sel_1 33
		sel_0 92
		sel_213 8
		sel_6 49
		sel_8 138
		sel_9 65
		sel_301 40
	)
)

(instance leftShelves of Feature
	(properties
		sel_20 {leftShelves}
		sel_1 75
		sel_0 85
		sel_213 9
		sel_6 66
		sel_7 65
		sel_8 105
		sel_9 84
		sel_301 40
	)
)

(instance cabinet of Feature
	(properties
		sel_20 {cabinet}
		sel_1 81
		sel_0 125
		sel_213 10
		sel_6 112
		sel_7 66
		sel_8 138
		sel_9 94
		sel_301 40
	)
)

(instance crate2 of Feature
	(properties
		sel_20 {crate2}
		sel_1 190
		sel_0 115
		sel_213 12
		sel_6 87
		sel_7 163
		sel_8 142
		sel_9 218
		sel_301 40
	)
)

(instance crate3 of Feature
	(properties
		sel_20 {crate3}
		sel_1 176
		sel_0 79
		sel_213 13
		sel_6 71
		sel_7 164
		sel_8 87
		sel_9 187
		sel_301 40
	)
)

(instance poster of Feature
	(properties
		sel_20 {poster}
		sel_1 98
		sel_0 93
		sel_213 14
		sel_6 83
		sel_7 88
		sel_8 103
		sel_9 106
		sel_301 40
	)
)

(instance assortedTools of Feature
	(properties
		sel_20 {assortedTools}
		sel_1 234
		sel_0 104
		sel_213 15
		sel_6 94
		sel_7 220
		sel_8 114
		sel_9 246
		sel_301 40
	)
)

(instance canister of Feature
	(properties
		sel_20 {canister}
		sel_1 247
		sel_0 133
		sel_213 16
		sel_6 122
		sel_7 239
		sel_8 140
		sel_9 254
		sel_301 40
	)
)

(instance light of Feature
	(properties
		sel_20 {light}
		sel_1 293
		sel_0 68
		sel_213 17
		sel_6 69
		sel_7 283
		sel_8 77
		sel_9 303
		sel_301 40
	)
)

(instance rightShelf of Feature
	(properties
		sel_20 {rightShelf}
		sel_1 299
		sel_0 84
		sel_213 18
		sel_6 77
		sel_7 280
		sel_8 96
		sel_9 319
		sel_301 40
	)
)

(instance desk of Feature
	(properties
		sel_20 {desk}
		sel_1 298
		sel_0 110
		sel_213 19
		sel_6 102
		sel_7 277
		sel_8 119
		sel_9 319
		sel_301 40
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)

(instance sFX2 of Sound
	(properties
		sel_20 {sFX2}
		sel_99 1
	)
)
