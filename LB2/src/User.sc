;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

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
		(GetEvent evALL_EVENTS sel_346)
		(self sel_133: sel_346)
	)

	(method (sel_237 param1)
		(if argc
			(= sel_343 param1)
			(= sel_344 0)
		)
		(return sel_343)
	)

	(method (sel_133 param1 &tmp temp0 temp1 temp2 temp3)
		(= gMouseX (param1 sel_1:))
		(= gMouseY (param1 sel_0:))
		(= temp0 (param1 sel_31:))
		(= temp2 (param1 sel_61:))
		(if temp0
			(= gLastEvent param1)
			(if sel_345
				(MapKeyToDir param1)
			)
			(if (== temp0 256)
				(= temp0 4)
				(= temp1 (if (& temp2 $0003) 27 else 13))
				(= temp2 0)
				(param1 sel_31: temp0 sel_37: temp1 sel_61: temp2)
			)
			(if (and gPrints (gPrints sel_133: param1))
				(return 1)
			)
			(param1 sel_148:)
			(= temp0 (param1 sel_31:))
			(= temp1 (param1 sel_37:))
			(cond
				((& temp0 $0040)
					(cond
						((not (gUser sel_237:)))
						((and gDirectionHandler (gDirectionHandler sel_133: param1))
							(return 1)
						)
						(
							(and
								(or
									(and
										gTheIconBar
										(==
											(gTheIconBar sel_207:)
											(gTheIconBar sel_228:)
										)
									)
									(not gTheIconBar)
								)
								sel_341
								sel_343
								(gCast sel_122: sel_341)
								(sel_341 sel_133: param1)
							)
							(return 1)
						)
						(
							(and
								gPMouse
								sel_342
								(or (not (& temp0 $0004)) (!= temp1 0))
								(gPMouse sel_133: param1)
							)
							(return 1)
						)
					)
				)
				(
					(and
						(& temp0 $0004)
						(gUser sel_347:)
						gKeyDownHandler
						(gKeyDownHandler sel_133: param1)
					)
					(return 1)
				)
				(
					(and
						(& temp0 $0003)
						(gUser sel_347:)
						gMouseDownHandler
						(gMouseDownHandler sel_133: param1)
					)
					(return 1)
				)
			)
		)
		(if gTheIconBar
			(gTheIconBar sel_133: param1)
		)
		(= temp0 (param1 sel_31:))
		(= temp1 (param1 sel_37:))
		(if (and sel_342 (& temp0 $4000))
			(cond
				((and (& temp0 $1000) gWalkHandler (gWalkHandler sel_133: param1))
					(return 1)
				)
				(
					(and
						(& temp0 $1000)
						(gCast sel_122: sel_341)
						sel_343
						(sel_341 sel_133: param1)
					)
					(return 1)
				)
				(gUseSortedFeatures
					(OnMeAndLowY sel_110:)
					(gCast sel_119: 96 OnMeAndLowY param1)
					(gFeatures sel_119: 96 OnMeAndLowY param1)
					(gAddToPics sel_119: 96 OnMeAndLowY param1)
					(if
						(and
							(OnMeAndLowY sel_348:)
							((OnMeAndLowY sel_348:) sel_133: param1)
						)
						(return 1)
					)
				)
				((gCast sel_133: param1)
					(return 1)
				)
				((gFeatures sel_133: param1)
					(return 1)
				)
			)
			(if (and (not (param1 sel_73:)) (gRegions sel_133: param1))
				(return 1)
			)
		)
		(if temp0
			(cond
				((gGame sel_133: param1)
					(return 1)
				)
				((and gPrints (gPrints sel_133: param1))
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (sel_347 param1)
		(if argc
			(= sel_342 param1)
		)
		(return sel_342)
	)
)

(class Ego of Actor
	(properties
		sel_20 {Ego}
		sel_14 8192
		sel_349 0
	)

	(method (sel_110)
		(super sel_110:)
		(if (not sel_245)
			(self sel_161: Walk)
		)
	)

	(method (sel_57)
		(super sel_57:)
		(= sel_349
			(cond
				((<= sel_1 0) 4)
				((>= sel_1 319) 2)
				((>= sel_0 189) 3)
				((<= sel_0 (gCurRoom sel_340:)) 1)
				(else 0)
			)
		)
	)

	(method (sel_133 param1 &tmp temp0 temp1 temp2)
		(= temp1 (param1 sel_31:))
		(= temp2 (param1 sel_37:))
		(cond
			((and sel_142 (sel_142 sel_133: param1)) 1)
			((& temp1 $0040)
				(if (and (== (= temp0 temp2) 0) (& temp1 $0004))
					(param1 sel_73:)
					(return)
				)
				(if
					(and
						(& temp1 $0004)
						(== temp0 (gUser sel_344:))
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
					(switch gUseObstacles
						(0
							(self
								sel_312:
									MoveTo
									(param1 sel_1:)
									(+ (param1 sel_0:) sel_82)
							)
						)
						(1
							(self
								sel_312:
									PolyPath
									(param1 sel_1:)
									(+ (param1 sel_0:) sel_82)
							)
						)
						(2
							(self
								sel_312:
									PolyPath
									(param1 sel_1:)
									(+ (param1 sel_0:) sel_82)
									0
									0
							)
						)
					)
					(gUser sel_344: 0)
					(param1 sel_73: 1)
				else
					(super sel_133: param1)
				)
			)
			(else
				(super sel_133: param1)
			)
		)
		(param1 sel_73:)
	)

	(method (sel_350 param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			((gInventory sel_64: [param1 temp0]) sel_182: self)
		)
	)

	(method (sel_351 param1 param2 &tmp temp0)
		(if (self sel_238: param1)
			((= temp0 (gInventory sel_64: param1))
				sel_182: (if (== argc 1) -1 else param2)
			)
			(if (and gTheIconBar (== (gTheIconBar sel_225:) temp0))
				(gTheIconBar
					sel_225: 0
					sel_233: ((gTheIconBar sel_226:) sel_33: 999 sel_117:)
				)
			)
		)
	)

	(method (sel_238 param1 &tmp temp0)
		(if (= temp0 (gInventory sel_64: param1))
			(temp0 sel_353: self)
		)
	)

	(method (sel_352 param1)
		(if argc
			(= sel_53 (= sel_244 param1))
		)
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

	(method (sel_57 param1 param2)
		(if (and (param1 sel_218: param2) (> (param1 sel_0:) sel_354))
			(= sel_354 ((= sel_348 param1) sel_0:))
		)
	)
)
