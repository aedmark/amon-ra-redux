;;; Sierra Script 1.0 - (do not remove this comment)
(script# 15)
(include sci.sh)
(use Main)
(use BorderWindow)
(use IconI)
(use Osc)
(use ForwardCounter)
(use Timer)
(use Sound)
(use InvI)
(use View)
(use Obj)

(public
	invCode 0
	invWin 1
)

(class LBIconItem of IconI
	(properties
		sel_20 {LBIconItem}
		sel_2 -1
		sel_3 -1
		sel_4 -1
		sel_7 0
		sel_6 -1
		sel_9 0
		sel_8 0
		sel_29 0
		sel_33 -1
		sel_31 16384
		sel_37 -1
		sel_61 0
		sel_14 1
		sel_208 0
		sel_209 0
		sel_210 0
		sel_211 0
		sel_212 0
		sel_213 0
		sel_214 0
		sel_215 0
	)
	
	(method (sel_353)
		(return 0)
	)
)

(class LBInvItem of InvI
	(properties
		sel_20 {LBInvItem}
		sel_2 0
		sel_3 0
		sel_4 0
		sel_7 0
		sel_6 0
		sel_9 0
		sel_8 0
		sel_29 0
		sel_33 999
		sel_31 16384
		sel_37 0
		sel_61 0
		sel_14 0
		sel_208 0
		sel_209 0
		sel_210 0
		sel_211 0
		sel_212 0
		sel_213 0
		sel_214 0
		sel_215 0
		sel_166 0
		sel_142 0
		sel_74 0
	)
	
	(method (sel_110)
		(= sel_212 gSel_212)
		(super sel_110:)
	)
	
	(method (sel_300 param1)
		(gNarrator sel_20: sel_20 sel_540: 1)
		(cond 
			((== param1 1) (gLb2Messager sel_295: sel_213 1 0 0 0 15))
			((== param1 8) (gLb2Messager sel_295: sel_213 8 0 0 0 15))
			((not (proc999_5 param1 3 4 2 6 12 13)) (gLb2Messager sel_295: 0 47 0 0 0 15))
			(else (super sel_300: param1))
		)
	)
)

(instance invCode of Code
	(properties
		sel_20 {invCode}
	)
	
	(method (sel_110)
		(= gInv Inv)
		(Inv
			sel_110:
			sel_32: invWin
			sel_227: invHelp
			sel_393: invSelect
			sel_392: ok
			sel_118:
				Coupon
				Claim_Ticket
				Notebook
				Sandwich
				Baseball
				Desk_Key
				Press_Pass
				Pocket_Watch
				Skeleton_Key
				Meat
				Wire_Cutters
				Dagger_of_Ra
				Work_Boot
				Smelling_Salts
				Snake_Oil
				Lantern
				Cheese
				Garter
				Dinosaur_Bone
				Snake_Lasso
				Ankh_Medallion
				Pippin_s_Notepad
				Magnifying_Glass
				Light_Bulb
				Watney_s_File
				Animal_Hairs
				Bifocals
				Red_Hair
				Water_Glass
				Carbon_Paper
				Yvette_s_Shoe
				Grapes
				Evening_Gown
				Charcoal
				Wire
				Mummy
				invLook
				invHand
				invSelect
				invHelp
				ok
			sel_119: 211 global157
			sel_119: 214 15
			sel_119: 110
			sel_29: 2048
		)
	)
)

(instance invWin of InsetWindow
	(properties
		sel_20 {invWin}
		sel_60 -1
		sel_379 28
		sel_380 5
	)
	
	(method (sel_189 &tmp temp0 gInvSel_124 temp2)
		(= temp0 0)
		(= gInvSel_124 (gInv sel_124:))
		(while gInvSel_124
			(if
			(not ((= temp2 (NodeValue gInvSel_124)) sel_114: InvI))
				(= temp0
					(+
						temp0
						(CelWide (temp2 sel_2?) (temp2 sel_3?) (temp2 sel_4?))
					)
				)
			)
			(= gInvSel_124 (gInv sel_65: gInvSel_124))
		)
		(super sel_189:)
		(invLook sel_7: (/ (- (- sel_196 sel_194) temp0) 2))
	)
)

(instance ok of LBIconItem
	(properties
		sel_20 {ok}
		sel_2 991
		sel_3 3
		sel_4 0
		sel_33 999
		sel_14 67
		sel_213 17
		sel_215 12
	)
	
	(method (sel_110)
		(super sel_110:)
		(= sel_212 gSel_212_2)
	)
)

(instance invLook of LBIconItem
	(properties
		sel_20 {invLook}
		sel_2 991
		sel_3 2
		sel_4 0
		sel_33 1
		sel_37 1
		sel_14 129
		sel_213 16
		sel_215 12
	)
	
	(method (sel_110)
		(super sel_110:)
		(= sel_212 gSel_212_2)
	)
)

(instance invHand of LBIconItem
	(properties
		sel_20 {invHand}
		sel_2 991
		sel_3 0
		sel_4 0
		sel_33 2
		sel_37 4
		sel_213 14
		sel_215 12
	)
	
	(method (sel_110)
		(super sel_110:)
		(= sel_212 gSel_212_2)
	)
)

(instance invHelp of LBIconItem
	(properties
		sel_20 {invHelp}
		sel_2 991
		sel_3 1
		sel_4 0
		sel_33 9
		sel_37 12
		sel_14 3
		sel_213 15
		sel_215 12
	)
	
	(method (sel_110)
		(super sel_110:)
		(= sel_212 gSel_212_2)
	)
)

(instance invSelect of LBIconItem
	(properties
		sel_20 {invSelect}
		sel_2 991
		sel_3 4
		sel_4 0
		sel_33 999
		sel_213 18
		sel_215 12
	)
	
	(method (sel_110)
		(super sel_110:)
		(= sel_212 gSel_212_2)
	)
)

(instance Coupon of LBInvItem
	(properties
		sel_20 {Coupon}
		sel_2 83
		sel_3 1
		sel_33 83
		sel_37 10
		sel_14 2
		sel_213 7
	)
)

(instance Claim_Ticket of LBInvItem
	(properties
		sel_20 {Claim Ticket}
		sel_2 59
		sel_3 1
		sel_33 59
		sel_37 5
		sel_14 2
		sel_213 6
	)
)

(instance Notebook of LBInvItem
	(properties
		sel_20 {Notebook}
		sel_2 50
		sel_3 1
		sel_33 50
		sel_37 14
		sel_14 2
		sel_213 24
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(gInv sel_102:)
				(global2 sel_422: (ScriptID 20 0))
				(return)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance Sandwich of LBInvItem
	(properties
		sel_20 {Sandwich}
		sel_2 53
		sel_3 1
		sel_33 53
		sel_37 15
		sel_14 2
		sel_213 29
	)
	
	(method (sel_300 param1)
		(switch param1
			(11
				(gLb2Messager sel_295: sel_213 11 0 0 0 15)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance Baseball of LBInvItem
	(properties
		sel_20 {Baseball}
		sel_2 54
		sel_3 1
		sel_33 54
		sel_37 7
		sel_14 2
		sel_213 1
	)
)

(instance Desk_Key of LBInvItem
	(properties
		sel_20 {Desk Key}
		sel_2 52
		sel_3 1
		sel_33 52
		sel_37 16
		sel_14 2
		sel_213 9
	)
)

(instance Press_Pass of LBInvItem
	(properties
		sel_20 {Press Pass}
		sel_2 51
		sel_3 1
		sel_33 51
		sel_37 11
		sel_14 2
		sel_213 27
	)
)

(instance Pocket_Watch of LBInvItem
	(properties
		sel_20 {Pocket Watch}
		sel_2 75
		sel_3 1
		sel_33 75
		sel_37 17
		sel_14 2
		sel_213 26
	)
)

(instance Skeleton_Key of LBInvItem
	(properties
		sel_20 {Skeleton Key}
		sel_2 58
		sel_3 1
		sel_33 58
		sel_37 18
		sel_14 2
		sel_213 30
	)
)

(instance Meat of LBInvItem
	(properties
		sel_20 {Meat}
		sel_2 64
		sel_3 1
		sel_33 64
		sel_37 19
		sel_14 2
		sel_213 22
	)
)

(instance Wire_Cutters of LBInvItem
	(properties
		sel_20 {Wire Cutters}
		sel_2 76
		sel_3 1
		sel_33 76
		sel_37 21
		sel_14 2
		sel_213 38
	)
)

(instance Dagger_of_Ra of LBInvItem
	(properties
		sel_20 {Dagger of Ra}
		sel_2 71
		sel_3 1
		sel_33 71
		sel_37 22
		sel_14 2
		sel_213 8
	)
)

(instance Work_Boot of LBInvItem
	(properties
		sel_20 {Work Boot}
		sel_2 70
		sel_3 1
		sel_33 70
		sel_37 23
		sel_14 2
		sel_213 40
	)
)

(instance Smelling_Salts of LBInvItem
	(properties
		sel_20 {Smelling Salts}
		sel_2 68
		sel_3 1
		sel_33 68
		sel_37 24
		sel_14 2
		sel_213 31
	)
)

(instance Snake_Oil of LBInvItem
	(properties
		sel_20 {Snake Oil}
		sel_2 61
		sel_3 1
		sel_33 61
		sel_37 25
		sel_14 2
		sel_213 33
		sel_166 520
	)

	(method (sel_110)
		(= sel_4 (if global150 0 else 1))
		(super sel_110:)
	)

	(method (sel_216)
		(= sel_4 (if global150 0 else 1))
		(super sel_216: &rest)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gNarrator sel_20: sel_20 sel_540: 1)
				(cond 
					((== global150 4) (gLb2Messager sel_295: 33 1 9 0 0 15))
					((== global150 3) (gLb2Messager sel_295: 33 1 10 0 0 15))
					((== global150 2) (gLb2Messager sel_295: 33 1 11 0 0 15))
					((== global150 1) (gLb2Messager sel_295: 33 1 12 0 0 15))
					(else (gLb2Messager sel_295: 33 1 8 0 0 15))
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance Lantern of LBInvItem
	(properties
		sel_20 {Lantern}
		sel_2 84
		sel_3 1
		sel_33 84
		sel_37 26
		sel_14 2
		sel_213 19
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if (== sel_4 0)
					(gInv sel_102:)
					(global2 sel_146: sCrankLantern)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance Cheese of LBInvItem
	(properties
		sel_20 {Cheese}
		sel_2 63
		sel_3 1
		sel_33 63
		sel_37 27
		sel_14 2
		sel_213 5
	)
)

(instance Garter of LBInvItem
	(properties
		sel_20 {Garter}
		sel_2 80
		sel_3 1
		sel_33 80
		sel_37 28
		sel_14 2
		sel_213 12
	)
)

(instance Dinosaur_Bone of LBInvItem
	(properties
		sel_20 {Dinosaur Bone}
		sel_2 65
		sel_3 1
		sel_33 65
		sel_37 29
		sel_14 2
		sel_213 10
	)
)

(instance Snake_Lasso of LBInvItem
	(properties
		sel_20 {Snake Lasso}
		sel_2 62
		sel_3 1
		sel_33 62
		sel_37 30
		sel_14 2
		sel_213 32
	)
)

(instance Ankh_Medallion of LBInvItem
	(properties
		sel_20 {Ankh Medallion}
		sel_2 73
		sel_3 1
		sel_33 73
		sel_37 31
		sel_14 2
		sel_213 23
	)
)

(instance Pippin_s_Notepad of LBInvItem
	(properties
		sel_20 {Pippin's Notepad}
		sel_2 79
		sel_3 1
		sel_4 1
		sel_33 79
		sel_37 32
		sel_14 2
		sel_213 25
	)
	
	(method (sel_300 param1)
		(switch param1
			(43
				(gInv sel_102:)
				(proc0_3 35)
				(self sel_4: 0 sel_14: 2)
				(gGame sel_146: sRubPad)
			)
			(1
				(= sel_213 (if (proc0_2 35) 46 else 45))
				(super sel_300: param1)
			)
			(8
				(= sel_213 (if (proc0_2 35) 46 else 45))
				(super sel_300: param1)
			)
			(39
				(gLb2Messager sel_295: 25 39 0 0 0 15)
			)
			(4
				(gLb2Messager sel_295: 25 4 0 0 0 15)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance Magnifying_Glass of LBInvItem
	(properties
		sel_20 {Magnifying Glass}
		sel_2 55
		sel_3 1
		sel_33 55
		sel_37 8
		sel_14 2
		sel_213 21
	)
)

(instance Light_Bulb of LBInvItem
	(properties
		sel_20 {Light Bulb}
		sel_2 67
		sel_3 1
		sel_33 67
		sel_37 33
		sel_14 2
		sel_213 20
	)
)

(instance Watney_s_File of LBInvItem
	(properties
		sel_20 {Watney's File}
		sel_2 72
		sel_3 1
		sel_33 72
		sel_37 34
		sel_14 2
		sel_213 37
	)
)

(instance Animal_Hairs of LBInvItem
	(properties
		sel_20 {Animal Hairs}
		sel_2 82
		sel_3 1
		sel_33 82
		sel_37 35
		sel_14 2
		sel_213 35
	)
)

(instance Bifocals of LBInvItem
	(properties
		sel_20 {Bifocals}
		sel_2 78
		sel_3 1
		sel_33 78
		sel_37 36
		sel_14 2
		sel_213 2
	)
)

(instance Red_Hair of LBInvItem
	(properties
		sel_20 {Red Hair}
		sel_2 74
		sel_3 1
		sel_33 74
		sel_37 37
		sel_14 2
		sel_213 28
	)
)

(instance Water_Glass of LBInvItem
	(properties
		sel_20 {Water Glass}
		sel_2 57
		sel_3 1
		sel_33 57
		sel_37 38
		sel_14 2
		sel_213 36
	)
)

(instance Carbon_Paper of LBInvItem
	(properties
		sel_20 {Carbon Paper}
		sel_2 77
		sel_3 1
		sel_4 1
		sel_33 77
		sel_37 39
		sel_14 2
		sel_213 3
	)
)

(instance Yvette_s_Shoe of LBInvItem
	(properties
		sel_20 {Yvette's Shoe}
		sel_2 85
		sel_3 1
		sel_33 85
		sel_37 40
		sel_14 2
		sel_213 41
	)
)

(instance Grapes of LBInvItem
	(properties
		sel_20 {Grapes}
		sel_2 81
		sel_3 1
		sel_33 81
		sel_37 41
		sel_14 2
		sel_213 13
	)
)

(instance Evening_Gown of LBInvItem
	(properties
		sel_20 {Evening Gown}
		sel_2 60
		sel_3 1
		sel_33 60
		sel_37 42
		sel_14 2
		sel_213 11
	)
)

(instance Charcoal of LBInvItem
	(properties
		sel_20 {Charcoal}
		sel_2 56
		sel_3 1
		sel_33 56
		sel_37 43
		sel_14 2
		sel_213 4
	)
)

(instance Wire of LBInvItem
	(properties
		sel_20 {Wire}
		sel_2 66
		sel_3 1
		sel_33 66
		sel_37 44
		sel_14 2
		sel_213 39
	)
)

(instance Mummy of LBInvItem
	(properties
		sel_20 {Mummy}
		sel_2 87
		sel_3 1
		sel_33 87
		sel_37 9
		sel_14 2
		sel_213 42
	)
)

(instance sCrankLantern of Script
	(properties
		sel_20 {sCrankLantern}
	)
	
	(method (sel_144 theSel_29 &tmp temp0)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(lanternCrank
					sel_110:
					sel_153: (- (gEgo sel_1?) 10) (- (gEgo sel_0?) 40)
					sel_156: 0
					sel_155: 3
					sel_161: ForwardCounter 3 self
				)
			)
			(1
				(lanternCrank sel_155: 4 sel_156: 0)
				(= sel_139 120)
			)
			(2
				(lanternCrank sel_111:)
				(Lantern sel_4: (- 1 (Lantern sel_4?)))
				(= temp0 (if (Lantern sel_4?) 88 else 84))
				(gIconBar
					sel_207: (gIconBar sel_226?)
					sel_225: (Lantern sel_33: temp0 sel_117:)
					sel_177: (gIconBar sel_64: 5)
				)
				(lanternTimer sel_162: lanternTimer 0 3)
				((gIconBar sel_207?) sel_33: temp0)
				(gGame sel_588: sel_197: ((gIconBar sel_64: 5) sel_33?))
				(gIconBar sel_178: (gIconBar sel_64: 5))
				(self sel_111:)
			)
		)
	)
)

(instance lanternCrank of Prop
	(properties
		sel_20 {lanternCrank}
		sel_2 84
		sel_3 3
		sel_60 15
		sel_14 16
		sel_244 12
	)
)

(instance sRubPad of Script
	(properties
		sel_20 {sRubPad}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_141 (Sound sel_109:))
				(rubbingPad sel_110: sel_155: 2 sel_4: 2)
				(= sel_139 120)
			)
			(1
				(rubbingPad
					sel_155: 1
					sel_4: 0
					sel_244: 6
					sel_161: OscRubPad 4 sel_141 self
				)
			)
			(2
				(rubbingPad sel_155: 2 sel_4: 4)
				(= sel_139 60)
			)
			(3
				(gIconBar
					sel_207: (gIconBar sel_226?)
					sel_177: (gIconBar sel_64: 5)
				)
				(rubbingPad sel_111:)
				(gGame sel_588:)
				(gEgo sel_351: 33)
				(sel_141 sel_111:)
				(self sel_111:)
			)
		)
	)
)

(instance rubbingPad of Prop
	(properties
		sel_20 {rubbingPad}
		sel_1 130
		sel_0 70
		sel_2 563
		sel_3 1
		sel_60 15
		sel_14 16
	)
)

(instance lanternTimer of Timer
	(properties
		sel_20 {lanternTimer}
	)
	
	(method (sel_145)
		(if (< gSel_40 730)
			(Lantern sel_4: 0 sel_33: 84)
			(if (== (gIconBar sel_225?) Lantern)
				((gIconBar sel_226?) sel_33: 84)
			)
			(if (== gSel_582 88) (gGame sel_197: 84))
		)
	)
)

(class OscRubPad of Osc
	(properties
		sel_20 {OscRubPad}
		sel_42 0
		sel_143 0
		sel_239 1
		sel_158 0
		sel_240 0
		sel_469 -1
		sel_607 1
	)
	
	(method (sel_110 param1 theSel_469 theSel_607 theSel_143)
		(if (>= argc 2)
			(= sel_469 theSel_469)
			(if (>= argc 3)
				(= sel_607 theSel_607)
				(if (>= argc 4) (= sel_143 theSel_143))
			)
		)
		(super sel_110: param1 theSel_469 theSel_143)
	)
	
	(method (sel_242)
		(sel_607 sel_40: 51 sel_39:)
		(super sel_242:)
	)
)
