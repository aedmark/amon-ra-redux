;;; Sierra Script 1.0 - (do not remove this comment)
(script# 996)
(include sci.sh)
(use Main)
(use PolyPath)
(use Cycle)
(use View)
(use Obj)


(instance uEvt of Event
	(properties
		sel_20 {uEvt}
	)
)

(class User of Obj
	(properties
		sel_20 {User}
		sel_341 0
		sel_342 0
		sel_343 0
		sel_344 0
		sel_1 -1
		sel_0 -1
		sel_345 1
		sel_346 0
	)
	
	(method (sel_110)
		(= sel_346 uEvt)
	)
	
	(method (sel_57)
		(sel_346
			sel_31: 0
			sel_37: 0
			sel_61: 0
			sel_0: 0
			sel_1: 0
			sel_73: 0
			sel_147: 0
		)
		(GetEvent 32767 sel_346)
		(self sel_133: sel_346)
	)
	
	(method (sel_237 theSel_343)
		(if argc (= sel_343 theSel_343) (= sel_344 0))
		(return sel_343)
	)
	
	(method (sel_133 param1 &tmp temp0 temp1 temp2 temp3)
		(= gSel_1 (param1 sel_1?))
		(= gSel_0 (param1 sel_0?))
		(= temp0 (param1 sel_31?))
		(= temp2 (param1 sel_61?))
		(if temp0
			(= global24 param1)
			(if sel_345 (MapKeyToDir param1))
			(if (== temp0 256)
				(= temp0 4)
				(= temp1 (if (& temp2 $0003) 27 else 13))
				(= temp2 0)
				(param1 sel_31: temp0 sel_37: temp1 sel_61: temp2)
			)
			(if (and global92 (global92 sel_133: param1))
				(return 1)
			)
			(param1 sel_148:)
			(= temp0 (param1 sel_31?))
			(= temp1 (param1 sel_37?))
			(cond 
				((& temp0 $0040)
					(cond 
						((not (gUser sel_237:)))
						((and gLb2DH (gLb2DH sel_133: param1)) (return 1))
						(
							(and
								(or
									(and
										gIconBar
										(== (gIconBar sel_207?) (gIconBar sel_228?))
									)
									(not gIconBar)
								)
								sel_341
								sel_343
								(gSel_561 sel_122: sel_341)
								(sel_341 sel_133: param1)
							)
							(return 1)
						)
						(
							(and
								gPseudoMouse
								sel_342
								(or (not (& temp0 $0004)) (!= temp1 0))
								(gPseudoMouse sel_133: param1)
							)
							(return 1)
						)
					)
				)
				(
					(and
						(& temp0 $0004)
						(gUser sel_347:)
						gLb2KDH
						(gLb2KDH sel_133: param1)
					)
					(return 1)
				)
				(
					(and
						(& temp0 $0003)
						(gUser sel_347:)
						gLb2MDH
						(gLb2MDH sel_133: param1)
					)
					(return 1)
				)
			)
		)
		(if gIconBar (gIconBar sel_133: param1))
		(= temp0 (param1 sel_31?))
		(= temp1 (param1 sel_37?))
		(if (and sel_342 (& temp0 $4000))
			(cond 
				(
				(and (& temp0 $1000) gLb2WH (gLb2WH sel_133: param1)) (return 1))
				(
					(and
						(& temp0 $1000)
						(gSel_561 sel_122: sel_341)
						sel_343
						(sel_341 sel_133: param1)
					)
					(return 1)
				)
				(global34
					(OnMeAndLowY sel_110:)
					(gSel_561 sel_119: 96 OnMeAndLowY param1)
					(gSel_562 sel_119: 96 OnMeAndLowY param1)
					(gSel_563 sel_119: 96 OnMeAndLowY param1)
					(if
						(and
							(OnMeAndLowY sel_348?)
							((OnMeAndLowY sel_348?) sel_133: param1)
						)
						(return 1)
					)
				)
				((gSel_561 sel_133: param1) (return 1))
				((gSel_562 sel_133: param1) (return 1))
			)
			(if
			(and (not (param1 sel_73?)) (gRegions sel_133: param1))
				(return 1)
			)
		)
		(if temp0
			(cond 
				((gGame sel_133: param1) (return 1))
				((and global92 (global92 sel_133: param1)) (return 1))
			)
		)
		(return 0)
	)
	
	(method (sel_347 theSel_342)
		(if argc (= sel_342 theSel_342))
		(return sel_342)
	)
)

(class Ego of Actor
	(properties
		sel_20 {Ego}
		sel_1 0
		sel_0 0
		sel_82 0
		sel_55 0
		sel_213 0
		sel_214 -1
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_301 26505
		sel_299 0
		sel_302 26505
		sel_303 0
		sel_304 0
		sel_305 0
		sel_306 0
		sel_52 2
		sel_2 -1
		sel_3 0
		sel_4 0
		sel_60 0
		sel_5 0
		sel_14 8192
		sel_10 0
		sel_11 0
		sel_12 0
		sel_13 0
		sel_16 0
		sel_17 0
		sel_18 0
		sel_19 0
		sel_88 0
		sel_103 0
		sel_104 128
		sel_105 128
		sel_106 128
		sel_244 6
		sel_142 0
		sel_245 0
		sel_135 0
		sel_321 0
		sel_322 0
		sel_15 -32768
		sel_249 0
		sel_250 0
		sel_51 3
		sel_323 770
		sel_53 6
		sel_324 0
		sel_325 0
		sel_56 0
		sel_59 0
		sel_326 0
		sel_327 0
		sel_328 0
		sel_349 0
	)
	
	(method (sel_110)
		(super sel_110:)
		(if (not sel_245) (self sel_161: Walk))
	)
	
	(method (sel_57)
		(super sel_57:)
		(= sel_349
			(cond 
				((<= sel_1 0) 4)
				((>= sel_1 319) 2)
				((>= sel_0 189) 3)
				((<= sel_0 (global2 sel_340?)) 1)
				(else 0)
			)
		)
	)
	
	(method (sel_133 param1 &tmp temp0 temp1 temp2)
		(= temp1 (param1 sel_31?))
		(= temp2 (param1 sel_37?))
		(cond 
			((and sel_142 (sel_142 sel_133: param1)) 1)
			((& temp1 $0040)
				(if (and (== (= temp0 temp2) 0) (& temp1 $0004))
					(param1 sel_73?)
					(return)
				)
				(if
					(and
						(& temp1 $0004)
						(== temp0 (gUser sel_344?))
						(IsObject sel_56)
					)
					(= temp0 0)
				)
				(gUser sel_344: temp0)
				(self sel_339: temp0)
				(param1 sel_73: 1)
			)
			((& temp1 $4000)
				(if (& temp1 $1000)
					(switch global67
						(0
							(self
								sel_312: MoveTo (param1 sel_1?) (+ (param1 sel_0?) sel_82)
							)
						)
						(1
							(self
								sel_312: PolyPath (param1 sel_1?) (+ (param1 sel_0?) sel_82)
							)
						)
						(2
							(self
								sel_312: PolyPath (param1 sel_1?) (+ (param1 sel_0?) sel_82) 0 0
							)
						)
					)
					(gUser sel_344: 0)
					(param1 sel_73: 1)
				else
					(super sel_133: param1)
				)
			)
			(else (super sel_133: param1))
		)
		(param1 sel_73?)
	)
	
	(method (sel_350 param1 &tmp temp0)
		(= temp0 0)
		(while (< temp0 argc)
			((gInv sel_64: [param1 temp0]) sel_182: self)
			(++ temp0)
		)
	)
	
	(method (sel_351 param1 param2 &tmp temp0)
		(if (self sel_238: param1)
			((= temp0 (gInv sel_64: param1))
				sel_182: (if (== argc 1) -1 else param2)
			)
			(if (and gIconBar (== (gIconBar sel_225?) temp0))
				(gIconBar
					sel_225: 0
					sel_233: ((gIconBar sel_226?) sel_33: 999 sel_117:)
				)
			)
		)
	)
	
	(method (sel_238 param1 &tmp temp0)
		(if (= temp0 (gInv sel_64: param1))
			(temp0 sel_353: self)
		)
	)
	
	(method (sel_352 theSel_244)
		(if argc (= sel_53 (= sel_244 theSel_244)))
		(return sel_53)
	)
)

(class OnMeAndLowY of Code
	(properties
		sel_20 {OnMeAndLowY}
		sel_348 0
		sel_354 -1
	)
	
	(method (sel_110)
		(= sel_348 0)
		(= sel_354 -1)
	)
	
	(method (sel_57 theSel_348 param2)
		(if
			(and
				(theSel_348 sel_218: param2)
				(> (theSel_348 sel_0?) sel_354)
			)
			(= sel_354 ((= sel_348 theSel_348) sel_0?))
		)
	)
)
